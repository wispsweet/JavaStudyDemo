package com.study.first.controller;

import com.study.first.entity.Student;
import com.study.first.request.TestRequestVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("test")
    public String testSomething(){
    //反射测试

        Student student = new Student();
        student.setId("100");
        student.setCode("code");
        student.setName("name");
        student.setPass("pass");
        student.setMark("mark");

        Field[] fields = Student.class.getDeclaredFields();
        Class objClass = Student.class;
        List<Method> methodList = new ArrayList<>();

        for (int j=0; j< fields.length; j++) {
            String fieldName = fields[j].getName();
            String getFildName = "get" + fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
            try {
                Method method = objClass.getMethod(getFildName, new Class[]{});
                methodList.add(method);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Object value = "";
        try {
            value = methodList.get(2).invoke(student);
            System.out.println("value: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value.toString();
    }

}
