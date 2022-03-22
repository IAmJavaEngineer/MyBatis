package com.mybatis.mapper;

import com.mybatis.pojo.User;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SelectMapperTest {

    /**
     * 若查询的数据只有一条，可以通过实体类对象或集合接收
     * 若查询数据有多条，一定不能通过实体类对象接收，可以通过集合接收
     */
    @Test
    void getUserById() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);

    }

    /**
     *
     */
    @Test
    void getAllUserById() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUserById();
//        System.out.println(list);
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void getCount() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    void getUserByIdToMap() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        Map map = mapper.getUserByIdToMap(3);
        System.out.println(map);
    }

    @Test
    void getAllUserByIdToMap() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        List list = mapper.getAllUserByIdToMapInList();
//        System.out.println(list);
        for(Object map : list) {
            System.out.println(map);
        }
    }
    @Test
    void getAllUserByIdToMapKey() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        Map<Integer, Object> map = mapper.getAllUserByIdToMapKey();
//        System.out.println(map);
        //将Map集合变为Set集合，目的是为了使用iterator()方法，注意泛型的统一
        Set<Map.Entry<Integer, Object>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Object>> iterator = set.iterator();  //取得Iterator实例对象
        while (iterator.hasNext()) {     //迭代输出
            Map.Entry<Integer, Object> me = iterator.next();
            System.out.println(me.getKey() + "=" + me.getValue());
        }
        //使用foreach输出
        for(Map.Entry<Integer, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}