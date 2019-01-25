package com.luo.demo_boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

/**
 * @Athor luozhengchao
 * @Date 2019/1/25 7:48 PM
 */
@RestController
public class TestController {

    @RequestMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name){
        return "helloWorld : " + name;
    }
}
