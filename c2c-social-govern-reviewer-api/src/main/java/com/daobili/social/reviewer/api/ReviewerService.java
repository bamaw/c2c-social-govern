package com.daobili.social.reviewer.api;

import java.util.List;

/**
 * 评审员服务的接口
 * @author bamaw
 * @date 2021-01-03  15:58
 */
public interface ReviewerService {

    /**
     * 选择评审员
     * @param reportTaskId 举报任务id
     * @return list 评审员用户id
     */
    List<Long> selectReviewers(Long reportTaskId);


    /**
     * 完成投票
     * @param reviewerId 评审员id
     * @param reportTaskId 举报任务id
     */
    void finishVote(Long reviewerId, Long reportTaskId);

}
