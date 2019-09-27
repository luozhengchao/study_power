package com.luo.demo01.proxy.simple;

import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;

import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author luozhengchao
 * @Date 2019/3/16 3:44 PM
 */
public interface TargetA {

}

class TargetAImpl implements TargetA{

    public void test(){
        System.out.println("TargetAImpl");
    }
}

class ProxyB{

    public Object newInstance(Class target, InvocationHandler handler){
        Object o = Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, handler);
        return o;
    }
}

class HandlerC implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法执行");
        return "返回了";
    }
}

class Test{
    public static void main(String[] args) {
        ProxyB proxyB = new ProxyB();
        Object o = proxyB.newInstance(TargetA.class, new HandlerC());
        System.out.println(o);


    }
}
