package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUserById();

    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息，用Map集合接收
     */
    Map<String,Object> getUserByIdToMap(Integer id);

    /**
     * 查询所有用户信息，用List集合嵌套Map集合接收
     * @return
     */
    List<Map<String,Object>> getAllUserByIdToMapInList();

    /**
     * 查询所有用户信息，用@MapKey注解将每条数据转换的Map集合作为值，以原来map集合中的某一个字段为键，
     * 放在同一个map集合中
     */
    @MapKey("id")
    Map<Integer, Object> getAllUserByIdToMapKey();

    /**
     * 模糊查询
     */
    List<User> MoHuSelect(String username);
}
