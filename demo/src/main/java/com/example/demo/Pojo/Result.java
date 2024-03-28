package com.example.demo.Pojo;

public class Result {
    private int code;
    private String message;
    private Object data;

    // 构造方法
    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    // getter和setter方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 增删改成功响应
    public static Result success() {
        return new Result(1, "success", null);
    }

    // 查询成功响应
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    // 失败响应
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}