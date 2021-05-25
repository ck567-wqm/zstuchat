package com.wqm.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Result类,前后端分离常用的脚手架。
 * 用来封装返回的数据,报告返回状态。
 */
@Data
public class Result implements Serializable {

    /* 200是正常，非200表示异常 */
    private int code;
    private String msg;
    private Object data;

    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }

    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg) {
        return fail(410, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
