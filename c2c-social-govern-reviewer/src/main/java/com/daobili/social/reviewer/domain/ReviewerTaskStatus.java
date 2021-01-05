package com.daobili.social.reviewer.domain;

/**
 * 评审员任务执行的状态
 * @author bamaw
 * @date 2021-01-05  21:29
 */
public class ReviewerTaskStatus {

    /**
     * 评审员执行任务状态id
     */
    private Long id;

    /**
     * 评审员id
     */
    private Long reviewerId;

    /**
     * 举报任务id
     */
    private Long reportTaskId;

    /**
     * 评审员处理举报任务的状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getReportTaskId() {
        return reportTaskId;
    }

    public void setReportTaskId(Long reportTaskId) {
        this.reportTaskId = reportTaskId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
