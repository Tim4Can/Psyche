package cn.psyche.javaee.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
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
        return "{ \"code\": "+code+
                ", \"msg\": \""+msg+"\""+
                ", \"data\": "+data+" }";
    }

}
