package com.study.first.controller;

import com.study.first.entity.Student;
import com.study.first.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * User: YHC
 * Date: 2020/9/7 16:37
 * DESC:
 */
@Controller
@ResponseBody
@RequestMapping("/download")
public class DownloadController {

    @GetMapping("/excel")
    public void excelExport(HttpServletResponse response){
       //表头
        String[] arr = new String[]{"ID", "用户名", "账号", "密码", "备注"};

        List<Student> userData = new ArrayList<>();

        for (int j=0; j< 5; j++) {
            Student student = new Student();
            student.setId(String.valueOf(j));
            student.setCode("code");
            student.setName("name");
            student.setPass("密码");
            student.setMark("mark");
            userData.add(student);
        }
        ExcelUtils.export(response, userData, arr);
    }
}
