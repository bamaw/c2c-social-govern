package com.daobili.social.report.domain;

/**
 * 举报任务
 * @author bamaw
 * @date 2021-01-03  17:12
 */
public class ReportTask {

    /**
     * 举报任务id
     */
    private Long id;

    /**
     * 举报任务类型
     */
    private String type;

    /**
     * 举报用户id
     */
    private Long reportUserId;

    /**
     * 举报内容说明
     */
    private String reportContent;

    /**
     * 举报目标对象id
     */
    private Long targetId;

    /**
     * 举报任务处理  状态
     * 1 处理中
     * 2 已完成
     */
    private Integer reportStatus;

    /**
     * 举报任务结果
     * -1 未投票 1 通过 2 未通过
     */
    private Integer reportResult;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Integer getReportResult() {
        return reportResult;
    }

    public void setReportResult(Integer reportResult) {
        this.reportResult = reportResult;
    }
}
