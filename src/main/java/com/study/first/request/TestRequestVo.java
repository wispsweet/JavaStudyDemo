package com.study.first.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * User: YHC
 * Date: 2020/7/30 18:24
 * DESC:
 */
@Getter
@Setter
public class TestRequestVo implements Serializable {

    @Length(min = 1, max = 3, message = "name格式")
    private String name;
}
