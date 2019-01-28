package com.luo.demo_eureka_user2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luozhengchao
 * @Date 2019/1/28 10:57 AM
 */
@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "7901:" + name;
    }
}
