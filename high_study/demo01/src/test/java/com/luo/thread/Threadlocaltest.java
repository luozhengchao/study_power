package com.luo.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author luozhengchao
 * @Date 2019/3/2 4:44 PM
 */
public class Threadlocaltest {

    static class A implements Runnable{

        //CAS算法，基于底层的CPU实现，保证原子性
        private AtomicInteger a = new AtomicInteger();

        private int b;
        private int c;

        //可重入锁
        Lock lock = new ReentrantLock(true);

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 1000000; i++ ) {
                    b ++;
                }
            } finally {
                lock.unlock();
            }

            for (int i = 0; i < 1000000; i++ ) {
                c ++;
            }

            for (int i = 0; i < 1000000; i++ ) {
                a.addAndGet(1);
            }
        }

        public int getCountb(){
            return b;
        }
        public int getCountc(){
            return c;
        }
        public int getCounta(){
            return a.intValue();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);

        t1.start();
        t2.start();

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("b=" + a.getCountb());
        System.out.println("c=" + a.getCountc());
        System.out.println("a=" + a.getCounta());

    }
}
