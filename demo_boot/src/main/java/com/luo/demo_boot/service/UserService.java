package com.luo.demo_boot.service;

import com.luo.demo_boot.pojo.User;

import java.util.List;

/**
 * @Athor luozhengchao
 * @Date 2019/1/26 12:41 AM
 */
public interface UserService {

    List<User> find();

    User get(Integer id);
}