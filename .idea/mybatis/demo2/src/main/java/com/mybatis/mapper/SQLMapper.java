package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {
    /**
     * 模糊查询
     */
    List<User> MoHuSelect(String username);

    /**
     * 批量删除
     */
    int DeleteUser(@Param("ids") String ids);

    /**
     * 动态设置表名
     */
    List<User> getAllUser(@Param("table") String table);

    /**
     * 添加共嫩获取主键
     */
    int insertUser(User user);
}
