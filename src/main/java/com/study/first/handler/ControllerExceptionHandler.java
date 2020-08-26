package com.study.first.handler;

import com.study.first.errorException.BusinessException;
import com.study.first.response.TestResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * User: YHC
 * Date: 2020/7/31 10:10
 * DESC: (basePackages = "com.study.first.advice")
 */
@ControllerAdvice //用于监听@Controller修饰的类
public class ControllerExceptionHandler {

    @ResponseBody //用于返回json到前端
    @ExceptionHandler(Exception.class) //用于处理指定的exception
    public TestResponse handlerException(HttpServletRequest request, Exception e){

        TestResponse testResponse = new TestResponse();

        if (e instanceof BusinessException) {
            testResponse.setCode(((BusinessException) e).getCode());
            testResponse.setMessage(e.getMessage());
        } if (e instanceof HttpMessageNotReadableException) {
            testResponse.setCode(505);
            testResponse.setMessage("请求参数异常");
        } else {
            testResponse.setMessage(e.getMessage());
        }
        return testResponse;
    }
}
