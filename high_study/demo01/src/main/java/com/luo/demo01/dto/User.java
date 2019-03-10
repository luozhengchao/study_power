package com.luo.demo01.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @Author luozhengchao
 * @Date 2019/3/6 8:39 PM
 */
public class User {

    @NotNull
    private String name;

    private String age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
