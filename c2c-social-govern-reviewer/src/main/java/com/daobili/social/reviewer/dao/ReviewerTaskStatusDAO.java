package com.daobili.social.reviewer.dao;

import com.daobili.social.reviewer.domain.ReviewerTaskStatus;

/**
 * 评审员处理任务状态DAO接口
 * @author bamaw
 * @date 2021-01-05  21:45
 */
public interface ReviewerTaskStatusDAO {

    /**
     * 增加评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    void add(ReviewerTaskStatus reviewerTaskStatus);


    /**
     * 更新评审员任务处理举报任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    void update(ReviewerTaskStatus reviewerTaskStatus);
}
