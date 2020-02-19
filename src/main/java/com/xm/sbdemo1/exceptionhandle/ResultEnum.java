package com.xm.sbdemo1.exceptionhandle;

//规范返回码 返回信息 需自行添加发生路径和事件详情
public enum ResultEnum {

    UNKNOWN_ERROR(500, "未知错误"),
    SUCCESS(200, "OK"),
    ERROR(201, "error");


    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
