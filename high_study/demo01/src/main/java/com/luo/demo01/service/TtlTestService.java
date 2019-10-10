package com.luo.demo01.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @Author luozhengchao
 * @Date 2019/10/9 2:53 PM
 */
public interface TtlTestService {

    @Async
    void testThreadLocalAsyncThreadPoolTtl() throws Exception;
}
