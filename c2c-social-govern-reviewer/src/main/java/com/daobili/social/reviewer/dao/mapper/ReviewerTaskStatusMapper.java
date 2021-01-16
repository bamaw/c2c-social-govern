package com.daobili.social.reviewer.dao.mapper;

import com.daobili.social.reviewer.domain.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * 评审员任务执行状态Mapper组件
 * @author bamaw
 * @date 2021-01-05  21:40
 */
@Mapper
public interface ReviewerTaskStatusMapper {


    /**
     * 插入评审员任务处理状态
     * @param reviewerTaskStatus 评审员任务处理状态对象
     */
    @Insert("INSERT INTO reviewer_task_status(reviewer_id,report_task_is,status) " +
            "VALUES(#{reviewerId},#{reportTaskId},#{status})")
    void insert(ReviewerTaskStatus reviewerTaskStatus);


    /**
     * 更新评审员任务处理举报任务状态
     * @param reviewerTaskStatus 评审员任务处理状态对象
     */
    @Update("UPDATE reviewer_task_status " +
            "SET status=#{status} " +
            "WHERE report_task_id=#{reportTaskId} AND reviewer_id=#{reviewerId}")
    void update(ReviewerTaskStatus reviewerTaskStatus);

}
