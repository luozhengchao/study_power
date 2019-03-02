package com.luo.thread;

import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import java.util.Timer;

/**
 * @Author luozhengchao
 * @Date 2019/3/2 11:34 AM
 */
public class ThreadTest {

    String name;

    @Test
    public void test01(){
        Thread thread = new Thread(){
            public void run() {
                name = "helloWorld";
            }
        };

        thread.start();
        while (name == null){
            Thread.yield();//出让主线程cpu
        };
        System.out.println(name.toUpperCase());
    }

    Integer count =0;
    @Test
    public void test02() throws Exception{
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count);
    }


    //泛型类
    class A<T>{
        T t;
        public T getT(T t){
            this.t = t;
            return t;
        }

    }

    @Test
    public void test03(){
        A<? super Number> t = new A<>();
        Object t1 = t.getT(1);
        System.out.println(t.t);
    }

    //泛型方法
    class B{
        public <T> String getDog(T t){
            if (null != t){
                return "dog";
            }
            return "cat";
        }
    }

    @Test
    public void test04(){
        B b = new B();
        String a = b.getDog(null);
        System.out.println(a);

    }

    /**
     * 查看处理器个数
     */
    @Test
    public void test05(){
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
