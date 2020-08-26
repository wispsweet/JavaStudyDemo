package com.study.first.advice;

import com.study.first.errorException.BusinessException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.validation.*;
import javax.validation.groups.Default;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;

/**
 * User: YHC
 * Date: 2020/7/30 18:48
 * DESC:
 */
@ControllerAdvice
public class RequestControllerAdvice implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(body, Default.class);
        Iterator<ConstraintViolation<Object>> iterator = set.iterator();

        if (iterator.hasNext()) {
            throw new BusinessException(500, iterator.next().getMessage());
        }
        return body;
    }
}
