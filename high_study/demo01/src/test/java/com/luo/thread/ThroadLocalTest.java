package com.luo.thread;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author luozhengchao
 * @Date 2019/3/2 5:09 PM
 */
public class ThroadLocalTest {




    static class DateUtils{
        //保证SimpleDateFormat安全性
        static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

        public static String formate(Date date){
            String dateStr = null;
            SimpleDateFormat dateFormat = threadLocal.get();
            if (dateFormat == null){
                threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                System.out.println("创建对象:" + Thread.currentThread().getName());
                dateFormat = threadLocal.get();
            }
                dateStr = dateFormat.format(date);
            return dateStr;
        }

    }



    @Test
    public void test01() throws Exception{

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    System.out.println(DateUtils.formate(new Date()));
                }
            };
            list.add(thread);
        }

        for (Thread thread : list) {
            thread.start();
        }

        Thread.sleep(1000);
    }
}
