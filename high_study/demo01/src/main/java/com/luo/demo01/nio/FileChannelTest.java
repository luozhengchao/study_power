package com.luo.demo01.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 7:55 PM
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {

        //文件读到channel中
        FileChannel fileChannel = FileChannel.open(Paths.get("/Volumes/SHARE/github/high_study/demo01/src/main/java/com/luo/demo01/a.txt"), StandardOpenOption.READ);

        //把文件写入buffer
        //分配JVM内存2字节
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);


        int len = -1;
        do {
            //读取channel中的内容并
            len = fileChannel.read(byteBuffer);
            //切换为读模式
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                //输出
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.flip();
            //清除要在写模式下
            byteBuffer.clear();
        } while (len != -1);


    }
}
