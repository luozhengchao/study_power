package com.luo.demo01.controller;

import com.alibaba.fastjson.JSON;
import com.luo.demo01.dto.User;
import com.luo.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Author luozhengchao
 * @Date 2019/3/6 7:14 PM
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/save")
    @ResponseBody
    public String saveUser(User user){
        return JSON.toJSONString(userService.save(user));
    }

    @GetMapping(value = "/insert")
    @ResponseBody
    public String sayHello(String user){

        return userService.insert(user);

    }
}
