package com.luo.nio;


import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 8:37 PM
 */
public class ServerSocketChannelTest {

    /**
     * 服务器端
     */
    @Test
    public void server() throws IOException {

        //创建ServerSocketChannel对象
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //让对象在指定端口进行监听，socket也是传统的socket
        socketChannel.socket().bind(new InetSocketAddress(9999));
        //构建buffer对象接收数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        while (true){
            SocketChannel accept = socketChannel.accept();
            accept.read(byteBuffer);
            byteBuffer.flip();
            String s = new String(byteBuffer.array());
            System.out.println(s);
            accept.close();
        }

    }

    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {

        //创建对象并连接端口
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(9999));

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //向服务端发送数据
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        socketChannel.close();

    }
}
