package com.daobili.social.report.domain;

/**
 * 举报任务投票
 * @author bamaw
 * @date 2021-01-05  23:03
 */
public class ReportTaskVote {

    /**
     * 举报任务投票id
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
     * 投票结果
     */
    private Integer voteResult;

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

    public Integer getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(Integer voteResult) {
        this.voteResult = voteResult;
    }
}
