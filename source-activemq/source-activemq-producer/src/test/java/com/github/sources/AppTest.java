package com.github.sources;


import com.github.sources.activemq.producer.ProducerApplication;
import com.github.sources.activemq.producer.spring.SpringProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class AppTest {

    @Autowired
    private SpringProducer springProducer;

    @Test
    public void test() {
        springProducer.sendMessage();
    }
}
