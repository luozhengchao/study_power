package com.luo.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.luo.demo01.dto.User;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

/**
 * @Author luozhengchao
 * @Date 2019/9/27 1:55 PM
 */
public class ThreadLocalTest {

    @Test
    public void test() {
        UserHandler.set("AA");
        UserHandler.setInheritable("AA");

        System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
        System.out.println(Thread.currentThread().getName() + "==Inheritable===" + JSON.toJSONString(UserHandler.getInheritable()));
        System.out.println(Thread.currentThread().getName() + "==ali===" + JSON.toJSONString(UserHandler.getAli()));
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "==thread===" +JSON.toJSONString(UserHandler.get()));
                System.out.println(Thread.currentThread().getName() + "==Inheritable===" +JSON.toJSONString(UserHandler.getInheritable()));
                System.out.println(Thread.currentThread().getName() + "==ali===" +JSON.toJSONString(UserHandler.getAli()));
            }
        };
        thread.start();

    }


    @Test
    public void testo2() throws InterruptedException {
        ExecutorService  executor = Executors.newFixedThreadPool(1);
        executor = TtlExecutors.getTtlExecutorService(executor);
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);

        UserHandler.set("AA");
        UserHandler.setInheritable("AA");
        UserHandler.setAli("AA");

        System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
        System.out.println(Thread.currentThread().getName() + "==Inheritable===" + JSON.toJSONString(UserHandler.getInheritable()));
        System.out.println(Thread.currentThread().getName() + "==ali===" + JSON.toJSONString(UserHandler.getAli()));

        soutStr(executor, latch1);

        System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
        System.out.println(Thread.currentThread().getName() + "==Inheritable===" + JSON.toJSONString(UserHandler.getInheritable()));
        System.out.println(Thread.currentThread().getName() + "==ali===" + JSON.toJSONString(UserHandler.getAli()));



        latch1.await();

        System.out.println("=====================");

        UserHandler.set("BBB");
        UserHandler.setInheritable("BBB");
        UserHandler.setAli("BBB");

        System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
        System.out.println(Thread.currentThread().getName() + "==Inheritable===" + JSON.toJSONString(UserHandler.getInheritable()));
        System.out.println(Thread.currentThread().getName() + "==ali===" + JSON.toJSONString(UserHandler.getAli()));

        soutStr(executor, latch2);


        latch2.await();


    }

    private void soutStr(ExecutorService executor, CountDownLatch latch1) {
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
            System.out.println(Thread.currentThread().getName() + "==Inheritable===" +JSON.toJSONString(UserHandler.getInheritable()));
            System.out.println(Thread.currentThread().getName() + "==ali===" +JSON.toJSONString(UserHandler.getAli()));
            latch1.countDown();
            UserHandler.clear();

        });
    }


    static class UserHandler {

        private static final ThreadLocal<String> USER_THREAD_LOCAL = new ThreadLocal<>();
        private static final InheritableThreadLocal<String> USER_INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();
        private static final TransmittableThreadLocal<String> USER_ALI = new TransmittableThreadLocal<>();

        private static String get() {
            return USER_THREAD_LOCAL.get();
        }

        private static void set(String user) {
            USER_THREAD_LOCAL.set(user);
        }

        private static void clear(){
            USER_THREAD_LOCAL.remove();
            USER_INHERITABLE_THREAD_LOCAL.remove();
            USER_ALI.remove();
        }

        private static String getInheritable() {
            return USER_INHERITABLE_THREAD_LOCAL.get();
        }

        private static void setInheritable(String user) {
            USER_INHERITABLE_THREAD_LOCAL.set(user);
        }

        private static String getAli() {
            return USER_ALI.get();
        }

        private static void setAli(String user) {
            USER_ALI.set(user);
        }


    }

    @Test
    public void test03(){
        for (long i = 0; i < 1000000000000L; i++) {
            UserHandler.setAli("附近发达地方附近的法律干净利索大概几时帝国时代gas郭德纲大发的房间；赶快来春江郦城伽伽的郭德纲的嘎打广告房间里的开发大幅度；管理发电量将；高低贵贱看到过");
        }
    }

}

