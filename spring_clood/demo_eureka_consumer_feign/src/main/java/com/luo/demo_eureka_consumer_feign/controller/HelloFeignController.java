package com.luo.demo_eureka_consumer_feign.controller;

import com.luo.demo_eureka_consumer_feign.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luozhengchao
 * @Date 2019/1/28 4:40 PM
 */
@RestController
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
       return helloFeignService.hello(name);
    }
}
