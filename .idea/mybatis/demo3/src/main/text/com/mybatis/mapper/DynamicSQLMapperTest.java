package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicSQLMapperTest {

    @Test
    void getEmpByConditionIf() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        assert mapper != null;
        List<Emp> list = mapper.getEmpByConditionIf(new Emp(null, null, null, "男", "123@qq.com"));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    void getEmpByConditionWhere() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        assert mapper != null;
        List<Emp> list = mapper.getEmpByConditionWhere(new Emp(null, "张三", null, null, null));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    void getEmpByConditionTrim() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        assert mapper != null;
        List<Emp> list = mapper.getEmpByConditionTrim(new Emp(null, null, null, null, null));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    void getEmpByConditionChooseWhenOtherwise() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        assert mapper != null;
        List<Emp> list = mapper.getEmpByConditionChooseWhenOtherwise(new Emp(null, "张三", 100, null, null));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    void foreachDeleteMoreByArray() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        int i = mapper.foreachDeleteMoreByArray(new Integer[]{1,2,3});
        System.out.println(i);
    }

    @Test
    void insertMoreByList() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp2 = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp3 = new Emp(null, "a", 23, "男", "123@qq.com");
        Emp emp4 = new Emp(null, "a", 23, "男", "123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3, emp4);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }

    @Test
    void getEmpByColumns() {
        DynamicSQLMapper mapper = MapperUtils.getMapper(DynamicSQLMapper.class);
        assert mapper != null;
        List<Emp> list = mapper.getEmpByColumns();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}