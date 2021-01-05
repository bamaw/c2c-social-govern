package com.daobili.social.report.dao.impl;

import com.daobili.social.report.dao.ReportTaskVoteDAO;
import com.daobili.social.report.dao.mapper.ReportTaskVoteMapper;
import com.daobili.social.report.domain.ReportTaskVote;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

/**
 * 举报任务投票DAO组件
 * @author bamaw
 * @date 2021-01-05  23:33
 */
@Repository
public class ReportTaskVoteDAOImpl implements ReportTaskVoteDAO {


    /**
     * 举报任务投票Mapper组件
     */
    @Resource
    private ReportTaskVoteMapper reportTaskVoteMapper;


    /**
     * 增加举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    @Override
    public void add(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.insert(reportTaskVote);
    }

    /**
     * 更新举报任务投票
     * @param reportTaskVote 举报任务投票
     */
    @Override
    public void update(ReportTaskVote reportTaskVote) {
        reportTaskVoteMapper.update(reportTaskVote);
    }

    /**
     * 查询举报任务的所有投票
     * @param reportTaskId 举报任务id
     * @return list 举报任务投票
     */
    @Override
    public List<ReportTaskVote> queryByReportTaskId(Long reportTaskId) {
        return reportTaskVoteMapper.selectByReportTaskId(reportTaskId);
    }
}
