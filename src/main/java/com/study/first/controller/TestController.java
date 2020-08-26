package com.study.first.controller;

import com.study.first.request.TestRequestVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * User: YHC
 * Date: 2020/7/30 18:22
 * DESC:
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    //获取Apollo中的配置
//    @Value("${timeout}")
//    private String timeout;
//
//    @Value("${user.ports}")
//    private String userPorts;

//    //获取当前环境
//    @Value("${spring.profiles.active}")
//    private String env;

    @PostMapping("/first")
    public String firstMethod(@RequestBody TestRequestVo params){
//        System.out.println("env:" + env);
//        System.out.println("timeout:" + timeout);
//        System.out.println("userPorts:" + userPorts);
        return "result...";
    }

    @PostMapping("/two")
    public String twoMethod(){
        return "two...";
    }

    public String rabbitMQconsumer(){

        return "rabbitMQconsumer data : ";
    }

}
