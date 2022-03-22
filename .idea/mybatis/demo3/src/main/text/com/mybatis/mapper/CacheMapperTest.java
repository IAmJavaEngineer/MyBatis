package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.MapperUtils;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CacheMapperTest {

    /**
     * 一级缓存：
     * 一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就
     * 会从缓存中直接获取，不会从数据库重新访问
     * 使一级缓存失效的四种情况：
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     */

    @Test
    void testOneCache() {

        SqlSession sqlSession = SqlSessionUtils.getSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEId = mapper1.getEmpByEId(5);
        System.out.println(empByEId);
        /*
        一级缓存：
        第二次执行Emp empByEId1 = mapper.getEmpByEId(5);会从缓存中获取数据，sql语句不会重复执行
         */
        Emp empByEId1 = mapper1.getEmpByEId(5);
        System.out.println(empByEId1);
        /*
        就算重新执行sqlSession.getMapper(CacheMapper.class);也还是会从缓存中获取数据，sql语句不会重复执行
         */
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEId2 = mapper2.getEmpByEId(5);
        System.out.println(empByEId2);
        /*
        一级缓存的范围是SqlSession级别的，SqlSession不同，缓存也不同，sql语句会重复执行
         */
        SqlSession sqlSession2 = SqlSessionUtils.getSession();
        CacheMapper mapper3 = sqlSession2.getMapper(CacheMapper.class);
        Emp empByEId3 = mapper3.getEmpByEId(5);
        System.out.println(empByEId3);
        /*
        执行了sqlSession2的语句，再来执行sqlSession的相关语句，也会从sqlSession中的缓存获取数据，这代表开启新缓存不会刷新旧缓存
         */
        CacheMapper mapper4 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEId4 = mapper4.getEmpByEId(5);
        System.out.println(empByEId4);
        /*
        增删改会刷新（清空）缓存,sqlSession.clearCache();也会清空一级缓存，不会清空二级缓存
         */
//        sqlSession.clearCache();
        mapper4.insertEmp(new Emp(null, "abc", 19, "男", "12345"));
        CacheMapper mapper5 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEId5 = mapper5.getEmpByEId(5);
        System.out.println(empByEId5);

    }

    /**
     二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被
     缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
     二级缓存开启的条件：
     a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     b>在映射文件中设置标签<cache />
     c>二级缓存必须在SqlSession关闭或提交之后有效
     d>查询的数据所转换的实体类类型必须实现序列化的接口
     使二级缓存失效的情况：
     两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */
    @Test
    public void textTwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactoryBuilder.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEId(5));
            sqlSession1.close();//当sqlSession关闭后，数据就会保存在二级缓存中
            SqlSession sqlSession2 = sqlSessionFactoryBuilder.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEId(5));
            sqlSession2.close();
            SqlSession sqlSession3 = sqlSessionFactoryBuilder.openSession(true);
            CacheMapper mapper3 = sqlSession3.getMapper(CacheMapper.class);
            System.out.println(mapper3.getEmpByEId(5));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}