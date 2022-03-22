package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * MyBatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     * 表--实体类--mapper接口--映射文件
     */
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 更改用户信息
     * @return
     */
    int updateUser();

    /**
     * 删除用户信息
     * @return
     */
    int deleteUser();

    /**
     * 查询一个用户信息
     */
    User select();

    /**
     * 查询多条用户信息
     */
    List<User> selectAllUser();
}