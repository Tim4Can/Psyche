package com.javaee.psyche.entity;

public class ResultUtil {

    public static Result success(Object obj){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);

        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(int code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result noRecord(){
        Result result=new Result();
        result.setCode(ResultEnum.NO_RECORD.getCode());
        result.setMsg(ResultEnum.NO_RECORD.getMsg());

        return result;
    }
}
