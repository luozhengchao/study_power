package com.luo.demo01.proxy;

import org.springframework.cglib.proxy.Proxy;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 2:50 PM
 */
public class DaoProxyFactory {

    public static Object newProxy(Class<?> targetCls){
        return Proxy.newProxyInstance(targetCls.getClassLoader(), new Class[]{targetCls}, new DaoProxyHandler(targetCls));
    }
}