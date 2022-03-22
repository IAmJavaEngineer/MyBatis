package com.mybatis.mapper;

import com.mybatis.pojo.Emp;

public interface CacheMapper {
    Emp getEmpByEId(Integer id);
    void insertEmp(Emp emp);
}
