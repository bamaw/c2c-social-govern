package com.daobili.social.report.object.enums;

/**
 * 举报任务投票结果enum
 * @author bamaw
 * @date 2021-01-05  23:04
 */
public enum ReportTaskVoteResultEnum {


    /**
     * 未投票
     */
    UNVOTE(-1,"未投票"),

    /**
     * 通过
     */
    APPROVED(1,"通过"),

    /**
     * 未通过
     */
    UNAPPROVED(2,"未通过")
    ;

    private Integer code;
    private String message;

    ReportTaskVoteResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
