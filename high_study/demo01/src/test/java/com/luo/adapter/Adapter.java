package com.luo.adapter;

/**
 * @Author luozhengchao
 * @Date 2019/9/28 7:01 PM
 */
public class Adapter implements AdateeA{

    private TargetA targetA;

    @Override
    public void test() {
        targetA = new TargetA();
        targetA.A();
    }
}
