package com.luo.demo01.controller;

import com.luo.demo01.handler.TtlTestHandler;
import com.luo.demo01.service.TtlTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luozhengchao
 * @Date 2019/10/9 2:55 PM
 */
@RestController
@RequestMapping
public class TtlTestController {

    @Autowired
    private TtlTestService ttlTestService;

    @RequestMapping("/testTtl")
    public String testTransmittableThreadLocalThreadPool() throws Exception {
        System.out.println("我是Controller层处理线程，线程名：" + Thread.currentThread().getName());
        TtlTestHandler.set("我是：testTransmittableThreadLocalThreadPool");
        System.out.println("这里是处理过程，处理中.........");
        System.out.println(" TransmittableThreadLocalUtil保存的值为：" + TtlTestHandler.get());
        ttlTestService.testThreadLocalAsyncThreadPoolTtl();
        return "testInheritableThreadLocalThreadPool:";
    }

}
