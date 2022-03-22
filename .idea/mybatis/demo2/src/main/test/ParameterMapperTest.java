import com.mybatis.mapper.ParameterMapper;
import com.mybatis.mapper.SelectMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParameterMapperTest {

    @Test
    void insertUser() {
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        int count = mapper.insertUser(new User("庄九", "1234", 12,"男", "10086@qq.com"));
        System.out.println("count: " + count);
    }

    @Test
    void updateUser() {
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        int count = mapper.updateUser();
        System.out.println("count: " + count);
    }

    @Test
    void deleteUser() {

    }

    //返回单条用户信息
    @Test
    void selectSingleUser() {
//        String name = "王八";   //王八有三个，但返回值只能有一个所以报错
        String name = "王五";
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        User user = mapper.selectSingleUser(name);
        System.out.println(user);
    }

    //返回单条用户信息
    @Test
    void selectMultipleUser() {
        String name = "王八";
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        List<User> list = mapper.selectMultipleUser(name);
        for (User user : list
             ) {
            System.out.println(user);
        }
    }

    @Test
    void checkLogin() {
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("田七", "123");
        System.out.println(user);
    }
    @Test
    void selectVerifyLoginByMap() {
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","田七");
        map.put("password","123");
        User user = mapper.selectVerifyLoginByMap(map);
        System.out.println(user);
//        System.out.println("count: " + count);

    }
    @Test
    void checkLoginByParam() {
        ParameterMapper mapper = MapperUtils.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("庄九", "1234");
        System.out.println(user);
    }

    @Test
    void MoHuSelect() {
        SelectMapper mapper = MapperUtils.getMapper(SelectMapper.class);
        List<User> list = mapper.MoHuSelect("张三");
        for (User user : list) {
            System.out.println(user);
        }
    }




}