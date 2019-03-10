package com.luo.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 * 非阻塞NIO selector测试类
 *
 * @Author luozhengchao
 * @Date 2019/3/5 8:05 PM
 */
public class SelectorTest {

    /**
     * 服务器端
     * @throws Exception
     */
    @Test
    public void server() throws Exception {

        //获取通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9898));
        //设置非阻塞
        channel.configureBlocking(false);

        //获取selector对象
        Selector selector = Selector.open();
        //将通道注册到选择器上并指定监听接收事件
        channel.register(selector, SelectionKey.OP_ACCEPT);

        //轮询的方式获取已准备的事件
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                //判断是什么事件就绪
                if (next.isAcceptable()) {

                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);

                    accept.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    SocketChannel cancel = (SocketChannel) next.channel();

                    //读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = cancel.read(byteBuffer) )> 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }

                }
                //取消选择键
                iterator.remove();
            }
        }

    }

    /**
     * 客户端
     */
    @Test
    public void client() throws Exception{
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //切换非阻塞模式
        socketChannel.configureBlocking(false);

        //发送数据
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        Scanner sc = new Scanner(System.in);
        while (true){
//            String str = sc.next();

            new Thread(){
                @Override
                public void run() {
                    byteBuffer.put((new Date().toString() + "ln" + Thread.currentThread().getName() + "==" + Thread.activeCount()).getBytes());
                }
            }.start();

            Thread.sleep(2000);


            //切换模式
            byteBuffer.flip();

            //写数据
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //关闭通道
//        socketChannel.close();
        
    }

}
