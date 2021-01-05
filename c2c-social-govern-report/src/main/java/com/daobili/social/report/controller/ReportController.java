package com.daobili.social.report.controller;

import com.daobili.social.report.domain.ReportTask;
import com.daobili.social.report.service.ReportTaskService;
import com.daobili.social.reviewer.api.ReviewerService;
import com.daobili.social.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 举报服务接口
 * @author bamaw
 * @date 2021-01-03  15:53
 */
@RestController
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

    @Resource
    private ReportTaskService reportTaskService;


    /**
     * 提交举报接口
     * @param type 举报类型
     * @param reportUserId 举报用户id
     * @param reportContent 举报内容说明
     * @param targetId 举报目标id
     * @return
     */
    @PostMapping
    public String report(String type,
                         Long reportUserId,
                         String reportContent,
                         Long targetId) {

        ReportTask reportTask = new ReportTask();
        reportTask.setType(type);
        reportTask.setReportUserId(reportUserId);
        reportTask.setReportContent(reportContent);
        reportTask.setTargetId(targetId);

        // 在本地数据库增加一个举报任务
        reportTaskService.add(reportTask);


        // 调用评审员服务，选择一批评审员
        List<Long> reviewerIds = reviewerService.selectReviewers(reportTask.getId());


        return "success";
    }


}
