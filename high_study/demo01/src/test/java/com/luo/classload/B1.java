package com.luo.classload;

/**
 * @Author luozhengchao
 * @Date 2019/3/10 3:13 PM
 */
public class B1 {

    static {
        System.out.println("AAAA");
    }

    public B1() {
        System.out.println("CCCCCC");
    }
}
