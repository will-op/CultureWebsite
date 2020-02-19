package com.xm.sbdemo1.exceptionhandle;

public class BasicException extends RuntimeException {

    private Integer code;

    private String msg;

    private String path;

    private String info;

    public BasicException(Integer code, String msg, String path, String info) {
        this.code = code;
        this.msg = msg;
        this.path = path;
        this.info = info;
    }

    public BasicException(String path, String info) {
        this.path = path;
        this.info = info;
    }

    public BasicException(Integer code, String path) {
        this.code = code;
        this.path = path;
//        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
