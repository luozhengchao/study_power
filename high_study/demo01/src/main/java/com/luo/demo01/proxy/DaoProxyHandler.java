package com.luo.demo01.proxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 2:54 PM
 */
public class DaoProxyHandler implements InvocationHandler {

    private Class<?> targetCls;

    public DaoProxyHandler(Class<?> targetCls) {
        this.targetCls = targetCls;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoke " + targetCls.getName());
        System.out.println("执行hangdler方法");
        return null;
    }
}
