package com.study.first.errorException;

/**
 * User: YHC
 * Date: 2020/7/31 10:42
 * DESC:
 */
public class BusinessException extends RuntimeException {

    private int code = 200;

    private String message = "Exception Message...";

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(int code, String message){
        super(message);
        this.code = code;
    }

    public static BusinessException error(int code, String message){
        return new BusinessException(code ,message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
