package com.luo.demo01.service;

import com.luo.demo01.dto.User;

/**
 * @Author luozhengchao
 * @Date 2019/3/6 7:16 PM
 */
public interface UserService {

    String insert(String user);

    User save(User user);
}

