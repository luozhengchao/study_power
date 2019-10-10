package com.luo.demo01.service;

import com.luo.demo01.handler.TtlTestHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author luozhengchao
 * @Date 2019/10/9 2:54 PM
 */
@Service
public class TtlTestServiceImpl implements TtlTestService {

    @Async("piceaTaskExecutor")
    @Override
    public void testThreadLocalAsyncThreadPoolTtl() throws Exception {
        System.out.println("我是Service层处理线程，线程名：" + Thread.currentThread().getName());
        System.out.println(" TransmittableThreadLocalUtil：" + TtlTestHandler.get());
        TtlTestHandler.clear();
    }

}
