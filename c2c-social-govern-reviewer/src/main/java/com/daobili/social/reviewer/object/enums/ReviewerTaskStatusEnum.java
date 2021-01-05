package com.daobili.social.reviewer.object.enums;

/**
 * @author bamaw
 * @date 2021-01-05  21:09
 */
public enum ReviewerTaskStatusEnum {


    /**
     * 处理中
     */
    PROCESSING(1,"处理中"),

    /**
     * 处理完成
     */
    FINISHED(2,"处理完成")
    ;

    private Integer code;
    private String message;

    ReviewerTaskStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
