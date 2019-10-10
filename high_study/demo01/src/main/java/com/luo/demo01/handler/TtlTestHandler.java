package com.luo.demo01.handler;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author luozhengchao
 * @Date 2019/10/9 2:56 PM
 */
public class TtlTestHandler {

    private static final ThreadLocal<String> THREAD_LOCAL = new TransmittableThreadLocal();


    public static void set(String str){
        THREAD_LOCAL.set(str);
    }

    public static String get(){
        return THREAD_LOCAL.get();
    }

    public static void clear(){
        THREAD_LOCAL.remove();
    }

}
