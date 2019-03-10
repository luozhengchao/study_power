package com.luo.demo01.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author luozhengchao
 * @Date 2019/3/3 11:43 AM
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping(value = "/say/{user}")
    @ResponseBody
    public String sayHello(@PathVariable("user") String user){

        return user;
    }
}
