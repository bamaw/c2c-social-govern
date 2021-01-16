package com.daobili.social.report.service;

import com.daobili.social.report.domain.ReportTask;

/**
 * 举报任务Service接口
 * @author bamaw
 * @date 2021-01-03  17:49
 */
public interface ReportTaskService {

    /**
     * 增加一个举报任务
     * @param reportTask 举报任务
     */
    void add(ReportTask reportTask);

    /**
     * 通过id查询对应的举报任务
     * @param id
     * @return
     */
    ReportTask findById(Long id);
}
