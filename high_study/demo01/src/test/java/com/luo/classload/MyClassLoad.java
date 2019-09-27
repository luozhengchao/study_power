package com.luo.classload;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  自定义类加载器
 *
 * @Author luozhengchao
 * @Date 2019/3/10 2:37 PM
 */
public class MyClassLoad extends ClassLoader {

    String dri;

    public MyClassLoad(String dri) {
        this.dri = dri;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classDate = getClassDate(name);

        return defineClass(name, classDate, 0, classDate.length);
    }

    private byte[] getClassDate(String name) {
        String classPath = dri + name.replace('.', File.separatorChar) + ".class";
        System.out.println(classPath);
        InputStream in = null;
        try {
            in = new FileInputStream(classPath);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
