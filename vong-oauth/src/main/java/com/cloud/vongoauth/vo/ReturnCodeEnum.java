package com.cloud.vongoauth.vo;

public enum ReturnCodeEnum {

    OK(200),
    ERROR(500);

    private final int code;
    ReturnCodeEnum(int code){
        this.code=code;
    }
    public int getCode() {
        return code;
    }
}
