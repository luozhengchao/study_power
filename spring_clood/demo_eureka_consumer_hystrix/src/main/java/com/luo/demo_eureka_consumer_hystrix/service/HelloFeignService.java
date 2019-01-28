package com.luo.demo_eureka_consumer_hystrix.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author luozhengchao
 * @Date 2019/1/28 4:37 PM
 */
@FeignClient(value = "provider-user")
public interface HelloFeignService {

    /**
     * Feign中没有原生的@GetMapping/@PostMapping/@DeleteMapping/@PutMapping，要指定需要用method进行
     */
    @RequestMapping(value="/hello/{name}",method= RequestMethod.GET)
    String hello(@PathVariable("name") String name);

}


