package com.luo.demo01.aspact;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Author luozhengchao
 * @Date 2019/3/3 11:51 AM
 */
@Aspect
@Component
public class LogAspact {

    Logger logger = Logger.getLogger("test");

    private long startTome;

    @Pointcut(value = "execution(public * com.luo.demo01.controller..*.*(..))")
    public void weblog() {
    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        startTome = System.currentTimeMillis();
        logger.info("日志开始时间：" + startTome);
    }

    @After("weblog()")
    public void doAfter() {
        logger.info("花费时间：" + (System.currentTimeMillis() - startTome));
    }
}
