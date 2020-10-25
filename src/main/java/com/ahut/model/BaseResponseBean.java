package com.ahut.model;

/**
 * Created by GIOPPL
 * on 2020/10/24 21:49
 * TODO:
 */
public class BaseResponseBean<T> {
    private int code;
    private T data;
    private String msg;

    public BaseResponseBean(T data) {
        this.data = data;
    }
    public BaseResponseBean(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
