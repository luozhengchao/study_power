package com.luo.demo01.proxy;

/**
 * @Author luozhengchao
 * @Date 2019/3/4 2:56 PM
 */
public class Test {

    public static void main(String[] args) {
        DefaultSqlSession sqlSession = new DefaultSqlSession();
        TargetDAO mapper = sqlSession.getMapper(TargetDAO.class);
        mapper.getName();
    }
}
