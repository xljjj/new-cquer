package com.cqu.NewCQUer.pojo;

public class Result<T> {
    private  int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public Result(){

    }

    public Result(T data) {
        this.data = data;
    }
    public static Result<?> success(){
        Result<?> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data,String msg){
        Result<T> result = new Result<>(data);
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }
    public static <T> Result<T> success(int code,String msg){
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    
    public static Result<?> error(int code,String msg){
        Result<?> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
