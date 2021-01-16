package com.daobili.social.report.service.impl;

import com.daobili.social.report.dao.ReportTaskDAO;
import com.daobili.social.report.domain.ReportTask;
import com.daobili.social.report.object.enums.ReportTaskStatusEnum;
import com.daobili.social.report.object.enums.ReportTaskVoteResultEnum;
import com.daobili.social.report.service.ReportTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        // 初始化举报任务状态 处理中
        reportTask.setReportStatus(ReportTaskStatusEnum.PROCESSING.getCode());
        // 初始化举报任务结果 未投票
        reportTask.setReportResult(ReportTaskVoteResultEnum.UNVOTE.getCode());
        reportTaskDAO.add(reportTask);
    }

    /**
     * 通过id查询对应的举报任务
     * @param id 举报任务id
     * @return 举报任务
     */
    @Override
    public ReportTask findById(Long id) {
        return reportTaskDAO.findById(id);
    }
}
