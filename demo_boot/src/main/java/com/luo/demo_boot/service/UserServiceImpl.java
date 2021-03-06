package com.luo.demo_boot.service;

import com.luo.demo_boot.mapper.UserMapper;
import com.luo.demo_boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author luozhengchao
 * @Date 2019/1/26 12:46 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public List<User> find() {
        return userMapper.find();
    }

    @Override
    public User get(Integer id){
        return userMapper.get(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
