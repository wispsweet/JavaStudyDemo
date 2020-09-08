package com.study.first;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//不自动加载receiver包
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.study.first.receiver.*")
})
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(FirstApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        //SpringApplication.run(FirstApplication.class, args);
    }

}
