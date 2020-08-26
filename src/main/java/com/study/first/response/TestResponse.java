package com.study.first.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * User: YHC
 * Date: 2020/7/31 11:36
 * DESC:
 */
@Getter
@Setter
@ToString
public class TestResponse implements Serializable {
    private int code = 200;

    private String message;

    private Object data;

    public TestResponse(){

    }

    public TestResponse(String message){
        this.message = message;
    }
}
