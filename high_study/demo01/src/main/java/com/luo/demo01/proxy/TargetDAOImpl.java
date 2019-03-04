package com.luo.demo01.proxy;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 2:40 PM
 */
public class TargetDAOImpl implements TargetDAO {

    @Override
    public void getName() {
        System.out.println("TargetDAOImpl getName");
    }
}
