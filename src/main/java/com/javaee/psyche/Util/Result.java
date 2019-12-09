package com.javaee.psyche.Util;

import lombok.Data;

@Data public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(){
        super();
    }

    public Result(int code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    @Override
    public String toString(){
        return "{code="+code+
                ", msg='"+msg+"\'"+
                ", data="+data+" }";
    }

}
