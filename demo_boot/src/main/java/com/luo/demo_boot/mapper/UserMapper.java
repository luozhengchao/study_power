package com.luo.demo_boot.mapper;

import java.util.List;

import com.luo.demo_boot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @Author luozhengchao
 * @Date 2019/1/26 12:37 AM
 */
@Mapper
public interface UserMapper {

    /**
     * 调用xml方式
     * @return
     */
    @Select("select * from user")
    List<User> find();

    /**
     * 调用注解方式
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User get(@Param("id") Integer id);

    @Insert("insert into test.user (NAME, BIRTHDAY, ADDRESS) VALUE (#{name},#{birthday},#{address})")
    void insert(User user);
}
