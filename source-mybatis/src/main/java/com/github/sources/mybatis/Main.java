package com.github.sources.mybatis;

import com.github.sources.mybatis.domain.TestEntity;
import com.github.sources.mybatis.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 *
 */
public class Main {

    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            TestEntity entity = testMapper.getById(1L);
            System.out.println(entity);
        } finally {
            sqlSession.close();
        }

    }
}
