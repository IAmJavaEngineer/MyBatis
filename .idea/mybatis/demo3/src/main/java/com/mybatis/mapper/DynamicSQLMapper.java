package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByConditionIf(Emp emp);

    List<Emp> getEmpByConditionWhere(Emp emp);

    List<Emp> getEmpByConditionTrim(Emp emp);

    List<Emp> getEmpByConditionChooseWhenOtherwise(Emp emp);

    int foreachDeleteMoreByArray(@Param("eids") Integer[] eids);

    int insertMoreByList(@Param("emps") List<Emp> emps);

    List<Emp> getEmpByColumns();
}
