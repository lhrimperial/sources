package com.github.source.rabbitmq.test;

import com.github.sources.rabbitmq.RabbitmqMain;
import com.github.sources.rabbitmq.sboot.queue.Sender;
import com.github.sources.rabbitmq.sboot.topic.TopicSender;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqMain.class)
public class RabbitMqTest {

    @Autowired
    private Sender sender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void topicSend(){
        topicSender.send1();
        topicSender.send2();
    }

    @Test
    public void manyReceiver(){
        for (int i=0;i<100;i++){
            sender.send2(i);
        }

    }

    @Test
    public void test(){
        sender.send();
    }
}
