package com.luo.classload;

/**
 * @Author luozhengchao
 * @Date 2019/3/10 3:11 PM
 */
public class MyClassLoadTest {

    public static void main(String[] args) {
        MyClassLoad load = new MyClassLoad("/Users/luozhengchao/Desktop/");
        try {
            Class<?> aClass = load.loadClass("com.luo.classload.B");
            Object o = aClass.newInstance();
            System.out.println(o.getClass());
            System.out.println(o.getClass().getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
