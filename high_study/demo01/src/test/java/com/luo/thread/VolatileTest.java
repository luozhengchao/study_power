package com.luo.thread;

import org.junit.Test;

/**
 * 线程安全的单例
 * @Author luozhengchao
 * @Date 2019/3/2 6:34 PM
 */
public class VolatileTest {

    //volatie关键字：保证可见性，避免指令重排序

    @Test
    public void test01(){
        A instance;
        int a = 0;
        do {
           instance = A.getInstance();
           if (instance != null){
               instance = null;
           }else {
               break;
           }
           a++;
        }while (true);
        System.out.println(instance + "" + a);
    }

    //实现读写锁：写了之后读立即可见


}

/**
 * 线程安全的单例
 */
class A{

    private static volatile A a;

    public static A getInstance(){
        if (a == null){
            synchronized (A.class){
                if (a == null){
                    a = new A();
                }
            }
        }
        return a;
    }

    private A(){
        System.out.println("生成了一个猫");
    }
}