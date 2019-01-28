package com.luo.demo_eureka_user.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luozhengchao
 * @Date 2019/1/28 10:10 AM
 */
@RestController
public class UserController {

    @RequestMapping("/hello/{name}")
    public String test(@PathVariable String name){
        return "7900: " + name;
    }
}
