package com.javaee.psyche.Util;

public enum ResultEnum {
    SUCCESS(200,"success"),
    FAIL(400,"fail"),
    UNAUTHORIZED(401,"unauthorized"),
    NOT_FOUND(404,"not found"),
    INTERNAL_SERVER_ERROR(500,"internal server error"),
    NO_RECORD(007,"no record");
    public int code;
    public String msg;

    ResultEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
