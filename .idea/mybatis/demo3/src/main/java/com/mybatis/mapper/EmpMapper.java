package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询所有员工信息
     */
    List<Emp> selectAllEmp();

    /**
     * 根据员工id查询员工信息以及对应的部门信息
     */
    List<Emp> getEmpAndDeptByEid(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工对应的部门信息(第一步，查询员工信息)
     * select * from t_emp where eid = ?
     */
    Emp getEmpAndDeptByStepByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询部门以及部门中所有员工的信息(第二步，根据did查询员工信息)
     * select * from t_emp where did = ?
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
