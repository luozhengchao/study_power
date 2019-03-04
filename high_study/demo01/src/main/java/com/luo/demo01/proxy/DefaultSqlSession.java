package com.luo.demo01.proxy;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 2:47 PM
 */
public class DefaultSqlSession {

    public <T>T getMapper(Class<?> targetCls){
        return (T)DaoProxyFactory.newProxy(targetCls);
    }
}
