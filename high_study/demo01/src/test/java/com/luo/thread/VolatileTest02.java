package com.luo.thread;

import com.jayway.jsonpath.internal.function.numeric.Sum;
import org.junit.Before;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author luozhengchao
 * @Date 2019/3/7 8:25 AM
 */
public class VolatileTest02 {

    ThreadPoolTaskExecutor pool;

    @Before
    public void initPool(){
        pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(10);
        pool.setMaxPoolSize(100);
        pool.setQueueCapacity(100);
        pool.initialize();
    }

    @Test
    public void test01(){
        int a = 10;
        pool.initialize();
        Future<Integer> task1 = pool.submit(new ClassA(a));
        Future<Integer> task2 = pool.submit(new ClassA(a));
        if (!task1.isDone() || !task2.isDone()){
            System.out.println("线程未结束");
        }
        try {
            Integer result1 = task1.get();
            System.out.println("result1=" + result1);

            Integer result2 = task2.get();
            System.out.println("result2=" + result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 多线程操作获取返回值
     */
    @Test
    public void test02(){
        int count=0;
        int Sum = 100;
        long startTime = System.currentTimeMillis();
        //循环起线程进行+操作
        ClassA classA;
        for (int i = 0; i < Sum; i++) {
            classA = new ClassA(10);
            Future<Integer> task = pool.submit(classA);
            try {
                Integer b = task.get();
                count +=b;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        //主线程操作
//        for (int i = 0; i < Sum; i++) {
//            classA = new ClassA(10);
//            try {
//                Integer call = (Integer) classA.call();
//                count +=call;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println(count);
        System.out.println("时间：" + (System.currentTimeMillis() - startTime));


    }



    /**
     * 多线程操作获取返回值
     */
    @Test
    public void test03() throws InterruptedException {
        Integer result = 0;
        Integer  a = 10;
        ClassB classB = new ClassB(a);
        for (int i = 0; i < 1000000; i++) {
            Thread.sleep(10);
            pool.execute(classB);
            result += classB.get();
        }

        System.out.println(result);

    }
}

class ClassA implements Callable {

    int a;

    public ClassA(int a) {
        this.a = a;
    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            a ++;
        }
        Thread.sleep(1000);
        return a;
    }

    public Integer get(){
        return a;
    }
}

class ClassB implements Runnable{

    int a;

    public ClassB(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            a ++;
        }
        System.out.println(Thread.currentThread().getName());
    }

    public synchronized Integer get(){
        return a;
    }



}