package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.MapperUtils;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmpMapperTest {

    @Test
    void selectAllEmp() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAllEmp();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
    @Test
    void getEmpAndDeptByEid() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getEmpAndDeptByEid(6);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
    @Test
    void getEmpAndDeptByStepByStep() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepByStepOne(6);
        System.out.println(emp.getEmpName());
        System.out.println("---------------------------------");
        System.out.println(emp.getDept());
    }
}