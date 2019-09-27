package com.luo.thread;

import com.alibaba.fastjson.JSON;
import com.luo.demo01.dto.User;
import org.junit.Test;

/**
 * @Author luozhengchao
 * @Date 2019/9/27 1:55 PM
 */
public class ThreadLocalTest {

    @Test
    public void test() {
        User user = new User();
        user.setAge("11");
        user.setName("tom");
        UserHandler.set(user);
        UserHandler.setInheritable(user);

        System.out.println(Thread.currentThread().getName() + "==thread===" + JSON.toJSONString(UserHandler.get()));
        System.out.println(Thread.currentThread().getName() + "==Inheritable===" + JSON.toJSONString(UserHandler.getInheritable()));

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "==thread===" +JSON.toJSONString(UserHandler.get()));
                System.out.println(Thread.currentThread().getName() + "==Inheritable===" +JSON.toJSONString(UserHandler.getInheritable()));
            }
        };
        thread.start();

    }


    static class UserHandler {

        private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();
        private static final InheritableThreadLocal<User> USER_INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal<>();

        private static User get() {
            return USER_THREAD_LOCAL.get();
        }

        private static void set(User user) {
            USER_THREAD_LOCAL.set(user);
        }


        private static User getInheritable() {
            return USER_INHERITABLE_THREAD_LOCAL.get();
        }

        private static void setInheritable(User user) {
            USER_INHERITABLE_THREAD_LOCAL.set(user);
        }

    }

}

