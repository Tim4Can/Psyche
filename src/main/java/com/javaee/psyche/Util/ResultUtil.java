package com.javaee.psyche.Util;

public class ResultUtil {

    public static Result success(Object obj){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(obj);

        return result;
    }

    public static Result success(){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
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


    public static Result error(ResultEnum e){

        Result result=new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());

        return result;

    }
}
