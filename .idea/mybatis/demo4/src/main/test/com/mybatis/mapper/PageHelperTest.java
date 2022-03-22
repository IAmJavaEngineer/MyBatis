package com.mybatis.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.MapperUtils;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
    /**
     * limit index,pageSize
     * index:当前页的起始索引，从0开始
     * pageSize:每页显示的条数
     * pageNum:当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis分页插件实现分页功能：
     * 1、需要在查询之前开启分页
     * PageHelper.startPage(pageNum, pageSize);
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> pageInfo = new PageInfo<>(list, navigatePages);
     * list表示分页数据
     * navigatePages表示当前导航分页的数量
     */
    @Test
    public void testPagehelper() {
        EmpMapper mapper = MapperUtils.getMapper(EmpMapper.class);
        //显示第pageNum页数据，每次显示pageSize条,显示的第一条数据是第index条的数据,因为index是从0开始，所以第一条数据对应的eid=index+1
        //select eid, emp_name, age, sex, email, did from t_emp LIMIT index,pageSize
        Page<Object> page = PageHelper.startPage(4, 4);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
        for (Emp emp : list) {
            System.out.println(emp);
        }
        System.out.println(page);
        System.out.println(pageInfo);
    }
}
