package com.daobili.social.reviewer.dao.mapper;

import com.daobili.social.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评审员任务执行状态Mapper组件
 * @author bamaw
 * @date 2021-01-05  21:40
 */
@Mapper
public abstract class ReviewerTaskStatusMapper {


    /**
     * 插入评审员任务处理状态
     * @param reviewerTaskStatus 评审员任务处理状态对象
     */
    @Insert("INSERT INTO reviewer_task_status(reviewer_id,report_task_is,status) " +
            "VALUES(#{reviewerId},#{reportTaskId},#{status})")
    public abstract void insert(ReviewerTaskStatus reviewerTaskStatus);

}
