package com.daobili.social.report.service.impl;

import com.daobili.social.report.dao.ReportTaskDAO;
import com.daobili.social.report.dao.ReportTaskVoteDAO;
import com.daobili.social.report.domain.ReportTask;
import com.daobili.social.report.domain.ReportTaskVote;
import com.daobili.social.report.object.enums.ReportTaskStatusEnum;
import com.daobili.social.report.object.enums.ReportTaskVoteResultEnum;
import com.daobili.social.report.service.ReportTaskVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author bamaw
 * @date 2021-01-05  23:44
 */
@Service
public class ReportTaskVoteServiceImpl implements ReportTaskVoteService {


    /**
     * 举报任务投票DAO组件
     */
    @Autowired
    private ReportTaskVoteDAO reportTaskVoteDAO;

    /**
     * 举报任务DAO组件
     */
    private ReportTaskDAO reportTaskDAO;


    /**
     * 初始化评审员对举报任务的投票
     * @param reviewerIds 评审员id
     * @param reportTaskId 举报任务id
     */
    @Override
    public void initVotes(List<Long> reviewerIds, Long reportTaskId) {

        for (Long reviewerId : reviewerIds) {
            ReportTaskVote votes = new ReportTaskVote();
            votes.setReviewerId(reviewerId);
            votes.setReportTaskId(reportTaskId);
            votes.setVoteResult(ReportTaskVoteResultEnum.UNVOTE.getCode());
            reportTaskVoteDAO.add(votes);
        }

    }

    /**
     * 对举报任务进行投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     * @param voteResult 投票结果
     */
    @Override
    public void vote(Long reviewerId, Long reportTaskId, Integer voteResult) {
        ReportTaskVote vote = new ReportTaskVote();
        vote.setReviewerId(reviewerId);
        vote.setReportTaskId(reportTaskId);
        vote.setVoteResult(voteResult);

        reportTaskVoteDAO.update(vote);

    }

    /**
     * 对举报任务进行归票
     * @param reportTaskId 举报任务id
     * @return 是否最终完成举报任务的投票结果
     */
    @Override
    public Boolean calculateVotes(Long reportTaskId) {
        List<ReportTaskVote> voteList = reportTaskVoteDAO.queryByReportTaskId(reportTaskId);

        Integer quorum = voteList.size() / 2 +1;

        /**
         * 初始化 投票类型 通过和未通过 未投票初始值
         */
        Integer approvedVotes = 0;
        Integer unapprovedVote = 0;
        Integer unvotes = 0;

        for (ReportTaskVote vote : voteList) {
            // 投票通过
            if (vote.getVoteResult().equals(ReportTaskVoteResultEnum.APPROVED.getCode())) {
                approvedVotes++;
            } else if (vote.getVoteResult().equals(ReportTaskVoteResultEnum.UNAPPROVED.getCode())) {
                unapprovedVote++;
            }
        }

        // 通过 大于 中间数
        if (approvedVotes >= quorum) {

            ReportTask reportTask = new ReportTask();
            reportTask.setId(reportTaskId);
            reportTask.setReportStatus(ReportTaskStatusEnum.FINISHED.getCode());
            reportTask.setReportResult(ReportTaskVoteResultEnum.APPROVED.getCode());
            reportTaskDAO.update(reportTask);
            return true;
        } else if (unapprovedVote >= quorum) {
            // 不通过 大于 中间数
            ReportTask reportTask = new ReportTask();
            reportTask.setId(reportTaskId);
            reportTask.setReportStatus(ReportTaskStatusEnum.FINISHED.getCode());
            reportTask.setReportResult(ReportTaskVoteResultEnum.UNAPPROVED.getCode());
            reportTaskDAO.update(reportTask);
            return true;
        }
        return false;
    }


    /**
     * 通过举报任务id获取举报任务投票list
     * @param reportTaskId 举报任务id
     * @return list
     */
    @Override
    public List<ReportTaskVote> getByReportTaskId(Long reportTaskId) {
        return reportTaskVoteDAO.queryByReportTaskId(reportTaskId);
    }

}
