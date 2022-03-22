package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import java.util.List;


class EmpMapperTest {

    @Test
    void countByExample() {
    }

    @Test
    void deleteByExample() {
    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    //根据条件查询
    @Test
    void selectByExample() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        assert mapper != null;
        //没有条件，就是查询所有
        List<Emp> list = mapper.selectByExample(null);
        for (Emp emp : list) {
            System.out.println(emp);
        }

        //创建一个条件
        EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("田七").andAgeGreaterThanOrEqualTo(20);
        example.or().andDidIsNotNull();
        List<Emp> list1 = mapper.selectByExample(example);
        for (Emp emp : list1) {
            System.out.println(emp);
        }
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByExampleSelective() {
    }

    @Test
    void updateByExample() {
    }

    @Test//update t_emp SET emp_name = ?, age = ?, email = ?, did = ? where eid = ?
    void updateByPrimaryKeySelective() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        assert mapper != null;
        //如果某个属性为null，则不会对相应字段进行修改
        int count = mapper.updateByPrimaryKeySelective(new Emp(13,"老八",12,null,"12345",3));
        System.out.println(count);
    }

    @Test//update t_emp set emp_name = ?, age = ?, sex = ?, email = ?, did = ? where eid = ?
    void updateByPrimaryKey() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        assert mapper != null;
        int count = mapper.updateByPrimaryKey(new Emp(13,"abc",12,"男","12345",3));
        System.out.println(count);
    }
}