package com.luo.demo_boot.controller;

import com.luo.demo_boot.pojo.User;
import com.luo.demo_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Athor luozhengchao
 * @Date 2019/1/26 12:49 AM
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public List<User> find() {
        return userService.find();
    }

    @RequestMapping("/get/{id}")
    public User get(@PathVariable Integer id){
        return userService.get(id);
    }
}
