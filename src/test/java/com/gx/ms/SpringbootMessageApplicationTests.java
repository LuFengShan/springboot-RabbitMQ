package com.gx.ms;

import com.gx.ms.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMessageApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 往RabbitAMPQ服务中写数据 ，要清楚交换器，路由规则和消息体
     */
    @Test
    public void testWriteMessage() {
        // 写入方式1,写入的消息必须是Message对象
        byte[] body = "abcdefg".getBytes();
        MessageProperties properties = new MessageProperties();
        rabbitTemplate.send("exchange.topic", "#.guang", new Message(body, properties));
        // 写入方式2，写入的消息是个Object对象
        rabbitTemplate.convertAndSend("exchange.fanout", "guang", new Book("aa", "bb"));
    }

    /**
     * 从消息队列取数据，只是从队列里面取，不用考虑交换器什么的
     */
    @Test
    public void testReadMessage() {
        Object guang = rabbitTemplate.receiveAndConvert("guang.xu");
        System.out.println(guang.getClass());
        System.out.println(guang);
    }

}
