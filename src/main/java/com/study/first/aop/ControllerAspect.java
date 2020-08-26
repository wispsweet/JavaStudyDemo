package com.study.first.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;



/**
 * User: YHC
 * Date: 2020/7/31 10:48
 * DESC: AOP
 */
@Component
@Aspect
public class ControllerAspect {

    @Pointcut("execution(* com.study.first.controller..*.*(..))")
    public void controllerPointCut(){

    }

    @Before("controllerPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("beforeAop:");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //class
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();

        //URL
        String url = request.getRequestURI();
        //method
        String method = request.getMethod();
        //args
        Object[] argsArr = joinPoint.getArgs();
        String jsonArgs = JSON.toJSONString(argsArr);


        System.out.println(argsArr.length);
        System.out.println(jsonArgs);


    }

    @After("controllerPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("afterAop:");
    }

    @AfterReturning(returning = "object",pointcut = "controllerPointCut()")
    public void afterRuntering(JoinPoint joinPoint, Object object){

    }

    @AfterThrowing(pointcut = "controllerPointCut()")
    public void afterThrowing(JoinPoint joinPoint){

    }
}
