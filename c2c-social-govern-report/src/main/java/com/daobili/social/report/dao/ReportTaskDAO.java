package com.daobili.social.report.dao;

import com.daobili.social.report.domain.ReportTask;

/**
 * 举报任务DAO接口
 * @author bamaw
 * @date 2021-01-03  17:37
 */
public interface ReportTaskDAO {


    /**
     * 增加一个举报任务
     * @param reportTask 举报任务
     */
    void add(ReportTask reportTask);
}
