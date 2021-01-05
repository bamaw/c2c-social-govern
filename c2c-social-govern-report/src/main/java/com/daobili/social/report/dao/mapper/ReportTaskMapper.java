package com.daobili.social.report.dao.mapper;

import com.daobili.social.report.domain.ReportTask;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
    @Insert("INSERT INTO report_task(type,report_user_id,report_content,target_id) " +
        "VALUES(#{type},#{reportUserId},#{reportContent},#{targetId})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void insert(ReportTask reportTask);
}
