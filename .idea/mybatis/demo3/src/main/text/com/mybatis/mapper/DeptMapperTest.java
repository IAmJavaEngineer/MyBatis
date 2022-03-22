package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import com.mybatis.utils.MapperUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeptMapperTest {

    @Test
    void getEmpAndDeptByStepTwo() {
    }

    @Test
    void getDeptAndEmpByDid() {
        DeptMapper mapper = MapperUtils.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDid(1);
        System.out.println(dept);
    }


    @Test
    void getDeptAndEmpByStep() {
        DeptMapper mapper = MapperUtils.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpBySteOne(1);
//        System.out.println(dept);
        System.out.println(dept.getDeptName());
    }
}