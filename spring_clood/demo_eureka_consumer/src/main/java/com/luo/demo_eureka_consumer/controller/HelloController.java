package com.luo.demo_eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author luozhengchao
 * @Date 2019/1/28 3:10 PM
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello/{name}")
    private String test(@PathVariable String name){
//       String url = "http://localhost:7901/hello/" + name;
       String url = "http://provider-user/hello/" + name;

       return restTemplate.getForObject(url, String.class);
    }
}
