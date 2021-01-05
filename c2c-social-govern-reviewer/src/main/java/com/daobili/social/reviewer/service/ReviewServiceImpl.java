package com.daobili.social.reviewer.service;

import com.daobili.social.reviewer.api.ReviewerService;
import com.daobili.social.reviewer.dao.ReviewerTaskStatusDAO;
import com.daobili.social.reviewer.domain.ReviewerTaskStatus;
import com.daobili.social.reviewer.object.enums.ReviewerTaskStatusEnum;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 评审员业务组件
 * @author bamaw
 * @date 2021-01-03  15:58
 */
@Service(
        version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin"
)
public class ReviewServiceImpl implements ReviewerService {

    /**
     * 评审员处理任务DAO组件
     */
    @Autowired
    private ReviewerTaskStatusDAO reviewerTaskStatusDAO;


    /**
     * 选择评审员
     * @param reportTaskId 举报任务id
     * @return list 评审员用户id
     */
    @Override
    public List<Long> selectReviewers(Long reportTaskId) {

        System.out.println("模拟通过算法选择一批评审员");

        List<Long> reviewerIds = new ArrayList<>();
        reviewerIds.add(1L);
        reviewerIds.add(2L);
        reviewerIds.add(3L);
        reviewerIds.add(4L);
        reviewerIds.add(5L);

        // 每个评审员要执行的任务依次录入数据库中
        for (Long reviewerId : reviewerIds) {
            ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();

            reviewerTaskStatus.setReportTaskId(reportTaskId);
            reviewerTaskStatus.setReviewerId(reviewerId);
            reviewerTaskStatus.setStatus(ReviewerTaskStatusEnum.PROCESSING.getCode());
            reviewerTaskStatusDAO.add(reviewerTaskStatus);
        }

        return reviewerIds;
    }
}
