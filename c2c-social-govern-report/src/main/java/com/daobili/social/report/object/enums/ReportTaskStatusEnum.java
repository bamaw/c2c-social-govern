package com.daobili.social.report.object.enums;

/**
 * 举报任务状态enum
 * @author bamaw
 * @date 2021-01-05  23:04
 */
public enum ReportTaskStatusEnum {


    /**
     * 处理中
     */
    PROCESSING(1,"处理中"),

    /**
     * 已完成
     */
    FINISHED(2,"已完成"),

    ;

    private Integer code;
    private String message;

    ReportTaskStatusEnum(Integer code, String message) {
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
