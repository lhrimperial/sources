package com.github.sources;


import com.github.sources.mybatis.ApplicationMyBatisMain;
import com.github.sources.mybatis.domain.TestEntity;
import com.github.sources.mybatis.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMyBatisMain.class)
public class AppTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test() {
        TestEntity entity = testMapper.getById(1L);
        System.out.println(entity);
    }
}
