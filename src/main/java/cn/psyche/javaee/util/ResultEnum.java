package cn.psyche.javaee.util;

public enum ResultEnum {
    SUCCESS(200,"success"),
    FAIL(400,"fail"),
    UNAUTHORIZED(401,"unauthorized"),
    NOT_FOUND(404,"not found"),
    HAVE_OCCUPIED(5,"have been occupied"),
    LOGIN_FAIL(1,"invalid password or user"),
    NOT_LOGIN(2,"login please"),
    PASSWORD_INCORRECT(3,"wrong password"),
    NO_RECORD(007,"no record"),
    INTERNAL_SERVER_ERROR(500,"internal server error");

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
