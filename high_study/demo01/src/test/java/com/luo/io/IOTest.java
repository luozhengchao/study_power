package com.luo.io;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Author luozhengchao
 * @Date 2019/4/1 9:50 PM
 */
public class IOTest {


    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        ServerSocket socket = new ServerSocket(9999);


        Socket accept = socket.accept();


    }


    /**
     * 客户端
     */
    @Test
    public void client(){
//        Clientsoc
    }
}
