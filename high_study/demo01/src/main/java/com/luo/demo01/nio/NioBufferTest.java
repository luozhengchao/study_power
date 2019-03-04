package com.luo.demo01.nio;

import java.nio.ByteBuffer;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 7:17 PM
 */
public class NioBufferTest {



    public static void main(String[] args) {

        //JVM
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //OS
        ByteBuffer.allocateDirect(1024);

        doPrint(byteBuffer.position(),byteBuffer.capacity(), byteBuffer.limit());

        byteBuffer.put("hello world".getBytes());

        doPrint(byteBuffer.position(),byteBuffer.capacity(), byteBuffer.limit());
        byteBuffer.flip();

        doPrint(byteBuffer.position(),byteBuffer.capacity(), byteBuffer.limit());
        byte b = byteBuffer.get();
        // 读模式limit为实际大小（11），写模式为分配的大小（1024）
        doPrint(byteBuffer.position(),byteBuffer.capacity(), byteBuffer.limit());
        System.out.println((char) b);

    }

    private static void doPrint(int position, int capacity, int limit) {
        System.out.println("position=" + position + ",capacity=" + capacity
         + ",limit=" + limit);
    }


}
