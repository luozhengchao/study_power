package com.luo.demo01.basicjava;

import com.luo.demo01.proxy.DefaultSqlSession;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型加强
 * @Author luozhengchao
 * @Date 2019/3/7 8:20 PM
 */
public class GenericTest {

    @Test
    public void test01(){
        User<DefaultSqlSession> user = new User<>();
        System.out.println(user.getName());
    }

}

/**
 * 泛型类
 */
class User<T>{

    public List<? extends T> getName(){
        return new ArrayList<>();
    }
}