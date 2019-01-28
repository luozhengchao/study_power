package com.luo.demo_eureka_consumer_hystrix.controller;

import com.luo.demo_eureka_consumer_hystrix.service.HelloFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author luozhengchao
 * @Date 2019/1/28 4:40 PM
 */
@RestController
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(@PathVariable("name") String name){
       return helloFeignService.hello(name);
    }

    /**
     * 对应上面的方法，参数必须一致，当访问失败时，hystrix直接回调用此方法
     */
    public String helloFallback(String name){
        //失败调用时，返回默认值
        return "tony";
    }
}
