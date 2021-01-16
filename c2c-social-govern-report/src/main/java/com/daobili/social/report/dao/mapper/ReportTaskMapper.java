package com.daobili.social.report.dao.mapper;

import com.daobili.social.report.domain.ReportTask;
import org.apache.ibatis.annotations.*;

/**
 * 举报任务SQL
 * @author bamaw
 * @date 2021-01-03  17:31
 */
@Mapper
public interface ReportTaskMapper {


    /**
     * 插入举报任务
     * @param reportTask
     */
    @Insert("INSERT INTO report_task(type,report_user_id,report_content,target_id,report_status,report_result) " +
        "VALUES(#{type},#{reportUserId},#{reportContent},#{targetId},#{reportStatus},#{reportResult})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void insert(ReportTask reportTask);

    /**
     * 更新举报任务 举报状态和举报结果
     * @param reportTask
     */
    @Update("UPDATE report_task " +
            "SET report_status=#{reportStatus}, report_result=#{reportResult} " +
            "WHERE id = #{id}")
    void update(ReportTask reportTask);


    /**
     * 通过id查询举报任务
     * @param id
     * @return
     */
    @Select("SELECT id,type,report_user_id,report_content,target_id,report_status,report_result FROM report_task WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "type", property = "type"),
            @Result(column = "report_user_id", property = "reportUserId"),
            @Result(column = "report_content", property = "reportContent"),
            @Result(column = "target_id", property = "targetId"),
            @Result(column = "report_status", property = "reportStatus"),
            @Result(column = "report_result", property = "reportResult")
    })
    ReportTask selectById(@Param("id") Long id);
}
