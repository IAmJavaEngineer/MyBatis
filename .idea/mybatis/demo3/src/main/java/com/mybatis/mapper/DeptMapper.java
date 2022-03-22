package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及员工对应的部门信息(第二步，根据did查询员工所对应的部门信息)
     * select * from t_dept where did = ?
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 通过collection解决一对多的映射关系
     * 获取部门以及部门中所有的员工信息
     */
    Dept getDeptAndEmpByDid(@Param("did") Integer did);

    /**
     * 通过分步查询部门中所有的员工信息
     * 分步查询第一步，查询部门信息
     */
    Dept getDeptAndEmpBySteOne(@Param("did") Integer did);
}
