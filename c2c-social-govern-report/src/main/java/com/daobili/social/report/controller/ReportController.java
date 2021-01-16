package com.daobili.social.report.controller;

import com.daobili.social.report.domain.ReportTask;
import com.daobili.social.report.domain.ReportTaskVote;
import com.daobili.social.report.service.ReportTaskService;
import com.daobili.social.report.service.ReportTaskVoteService;
import com.daobili.social.reviewer.api.ReviewerService;
import com.daobili.social.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 举报服务接口
 * @author bamaw
 * @date 2021-01-03  15:53
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    /**
     * 评审员服务
     */
    @Reference(
            version = "1.0.0",
            interfaceClass = ReviewerService.class,
            cluster = "failfast"
    )
    private ReviewerService reviewerService;

    /**
     * 奖励服务
     */
    @Reference(
            version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast"
    )
    private RewardService rewardService;

    /**
     * 举报任务Service组件
     */
    @Autowired
    private ReportTaskService reportTaskService;

    /**
     * 举报任务投票Service组件
     */
    @Autowired
    private ReportTaskVoteService reportTaskVoteService;



    /**
     * 提交举报接口
     * @param reportTask 举报任务
     * @return
     */
    @PostMapping("/report")
    public String report(ReportTask reportTask) {

        // 在本地数据库增加一个举报任务
        reportTaskService.add(reportTask);

        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(reportTask.getId());

        // 在本地数据库初始化这批评审员对举报任务的投票状态
        reportTaskVoteService.initVotes(reviewerIds, reportTask.getId());

        // 模拟发送push消息给评审员
        System.out.println("模拟发送push消息给评审员");
        return "success";
    }

    /**
     * 查询举报任务
     * @param reportTaskId 举报任务id
     * @return ReportTask
     */
    @GetMapping("/query/{id}")
    public ReportTask queryReportTaskById(@PathVariable("id") Long reportTaskId) {
        return reportTaskService.findById(reportTaskId);
    }

    /**
     * 对举报任务的投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     * @param voteResult 投票结果
     * @return
     */
    @PostMapping("/vote")
    public String vote(Long reviewerId, Long reportTaskId, Integer voteResult) {


        // 举报任务进行投票
        reportTaskVoteService.vote(reviewerId, reportTaskId, voteResult);

        // 通知评审员
        reviewerService.finishVote(reviewerId, reportTaskId);

        // 对举报任务投票进行归票处理
        Boolean hasFinishedVote = reportTaskVoteService.calculateVotes(reportTaskId);

        // 投票结束，发放奖励
        if (hasFinishedVote) {

            List<Long> reviewerIdList = new ArrayList<>();

            List<ReportTaskVote> reportTaskVoteList =
                    reportTaskVoteService.getByReportTaskId(reportTaskId);
            for (ReportTaskVote reportTaskVote : reportTaskVoteList) {
                reviewerIdList.add(reportTaskVote.getReviewerId());
            }
            // 为评审员发放奖励
            rewardService.giveReward(reviewerIdList);
        }

        return "success";
    }




}
