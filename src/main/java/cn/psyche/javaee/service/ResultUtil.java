package cn.psyche.javaee.service;

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
    public static Result error(ResultEnum e){
        Result result=new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }
}
