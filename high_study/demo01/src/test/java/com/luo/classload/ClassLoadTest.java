package com.luo.classload;

import org.testng.reporters.jq.Main;

import java.lang.reflect.Field;

/**
 *  类加载分析
 * 显示加载：class.forName,loadClass.load()
 * 隐式加载：new Obj(), 继承父类：使用子类对象时默认加载父类， 反射构建对象，访问类的静态成员
 * @Author luozhengchao
 * @Date 2019/3/10 10:57 AM
 */
public class ClassLoadTest {

    public static void main(String[] args) throws Exception {
        //1.隐式加载:访问静态成员
//        System.out.println(A.a2);

        System.out.println(new String("").getClass().getClassLoader());
        //2.显示加载
        //获取类加载器
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader.getParent().getParent());
        Class<?> aClass = classLoader.loadClass("com.luo.classload.A");
        Field a2 = aClass.getDeclaredField("a2");
        System.out.println(a2.get("c"));

    }
}
class A1{
    public int a=10;
    public Integer a1 = 11;
    public static Integer a2 = 12;
    public static final Integer a3 = 13;

   static  {
       System.out.println("初始化了 A");
    }
}