package com.daobili.social.report.service.impl;

import com.daobili.social.report.dao.ReportTaskDAO;
import com.daobili.social.report.domain.ReportTask;
import com.daobili.social.report.service.ReportTaskService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 举报任务Service接口实现类
 * @author bamaw
 * @date 2021-01-03  17:50
 */
@Service
public class ReportTaskServiceImpl implements ReportTaskService {


    @Autowired
    private ReportTaskDAO reportTaskDAO;


    /**
     * 增加一个举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTaskDAO.add(reportTask);
    }
}
