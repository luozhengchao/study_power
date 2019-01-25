package com.luo.demo_boot.mapper;

import java.util.List;

import com.luo.demo_boot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @Athor luozhengchao
 * @Date 2019/1/26 12:37 AM
 */
public interface UserMapper {

    //调用xml方式
    @Select("select * from user")
    public List<User> find();

    //调用注解方式
    @Select("select * from user where id=#{id}")
    public User get(@Param("id") Integer id);

}
