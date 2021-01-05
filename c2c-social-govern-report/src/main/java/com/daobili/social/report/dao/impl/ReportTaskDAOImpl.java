package com.daobili.social.report.dao.impl;

import com.daobili.social.report.dao.ReportTaskDAO;
import com.daobili.social.report.dao.mapper.ReportTaskMapper;
import com.daobili.social.report.domain.ReportTask;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 举报任务DAO接口实现类
 * @author bamaw
 * @date 2021-01-03  17:38
 */
@Repository
public class ReportTaskDAOImpl implements ReportTaskDAO {

    /**
     * 举报任务Mapper组件
     */
    @Resource
    private ReportTaskMapper reportTaskMapper;

    /**
     * 增加一个举报任务
     * @param reportTask 举报任务
     */
    @Override
    public void add(ReportTask reportTask) {
        reportTaskMapper.insert(reportTask);
    }
}
