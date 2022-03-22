package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

        /**
         * 添加用户信息(参数是实体类)
         * @return
         */
        int insertUser(User user);
        int updateUser();
        int deleteUser();

        /**
         * 根据用户名查询用户信息，只返回第一个查询到的信息
         * @param name
         * @return
         */
        User selectSingleUser(String name);

        /**
         * 根据用户名查询用户信息，结果可以有多条信息
         * @param name
         * @return
         */
        List<User> selectMultipleUser(String name);


        /**
         * 验证登录
         * @param
         */
        User checkLogin(String username, String password);

        /**
         * 验证登录（参数为泛型）
         * @param map
         */
        User selectVerifyLoginByMap(Map<String,Object> map);

        /**
         * 验证登录（使用@Param）
         */
        User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
