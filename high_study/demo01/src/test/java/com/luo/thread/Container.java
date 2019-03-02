package com.luo.thread;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @Author luozhengchao
 * @Date 2019/3/2 3:23 PM
 */
public class Container {

    private int size;

    private Object[] obj;

    public Container() {
        this(16);
    }

    public Container(int size) {
        this.obj = new Object[size];
    }

    public synchronized void add(Object a){
        //如果容量不足则扩容
        if (size == obj.length){
            obj = Arrays.copyOf(obj,obj.length * 2);
        }
        obj[size] = a;
        size ++;
    }

    public synchronized Object get(){
        Object result;
        if (size <=0){
            throw new RuntimeException("容器为空");
        }
        result = obj[0];
        System.arraycopy(obj,1,obj,0,size-1);
        //移动元素
        size --;
        obj[size] = null;
        return result;
    }

    public synchronized int size(){
        return size;
    }

    public static void main(String[] args) {
        Container container = new Container(1);
        System.out.println(container.size);
        container.add("a");
        container.add("b");
        System.out.println(container.size);
        System.out.println(container.get());
        System.out.println(container.get());
        System.out.println(container.size);
    }
}
