package com.daobili.social.report.service;


import com.daobili.social.report.domain.ReportTaskVote;

import java.util.List;

/**
 * 举报任务投票Service接口
 * @author bamaw
 * @date 2021-01-05  23:44
 */
public interface ReportTaskVoteService {


    /**
     * 初始化评审员对举报任务的投票
     * @param reviewerIds 评审员id
     * @param reportTaskId 举报任务id
     */
    void initVotes(List<Long> reviewerIds, Long reportTaskId);


    /**
     * 对举报任务进行投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     * @param voteResult 投票结果
     */
    void vote(Long reviewerId, Long reportTaskId, Integer voteResult);

    /**
     * 对举报任务进行归票
     * @param reportTaskId 举报任务id
     * @return 是否最终完成举报任务的投票结果
     */
    Boolean calculateVotes(Long reportTaskId);

    /**
     * 通过举报任务id获取举报任务投票list
     * @param reportTaskId 举报任务id
     * @return list
     */
    List<ReportTaskVote> getByReportTaskId(Long reportTaskId);

}
