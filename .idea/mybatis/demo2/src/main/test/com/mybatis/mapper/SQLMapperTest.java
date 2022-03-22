package com.mybatis.mapper;

import com.mybatis.pojo.User;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLMapperTest {

    @Test
    void moHuSelect() {
        SQLMapper sqlMapper = MapperUtils.getMapper(SQLMapper.class);
        List<User> list = sqlMapper.MoHuSelect("王五");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void deleteUser() {
        SQLMapper sqlMapper = MapperUtils.getMapper(SQLMapper.class);
        int count = sqlMapper.DeleteUser("1,2,3");
        System.out.println(count);
    }

    @Test
    void getAllUser() {
        SQLMapper sqlMapper = MapperUtils.getMapper(SQLMapper.class);
        List<User> t_user = sqlMapper.getAllUser("t_user");
        for (User user : t_user) {
            System.out.println(user);
        }
    }

    @Test
    void insertUser() {
        SQLMapper sqlMapper = MapperUtils.getMapper(SQLMapper.class);
        int count = sqlMapper.insertUser(new User("李四","1234",19,"男", "10011@168.com"));
        System.out.println(count);
    }
}