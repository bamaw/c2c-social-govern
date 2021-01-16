package com.daobili.social.reviewer.dao;

import com.daobili.social.reviewer.dao.mapper.ReviewerTaskStatusMapper;
import com.daobili.social.reviewer.domain.ReviewerTaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 评审员处理任务状态DAO组件
 * @author bamaw
 * @date 2021-01-05  21:48
 */
@Repository
public class ReviewerTaskStatusDAOImpl implements ReviewerTaskStatusDAO {


    /**
     * 评审员处理任务Mapper组件
     */
    @Autowired
    private ReviewerTaskStatusMapper reviewerTaskStatusMapper;

    /**
     * 增加评审处理任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    @Override
    public void add(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.insert(reviewerTaskStatus);
    }

    /**
     * 更新评审员任务处理举报任务状态
     * @param reviewerTaskStatus 评审处理任务状态
     */
    @Override
    public void update(ReviewerTaskStatus reviewerTaskStatus) {
        reviewerTaskStatusMapper.update(reviewerTaskStatus);
    }
}
