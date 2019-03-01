package com.gx.ms.service;

import com.gx.ms.entity.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServer {
    /**
     * 监听指定消息队列里面的消息,如果要监听队列中的消息，则必须开启@EnableRabbit注解
     */
    @RabbitListener(queues = "guang")
    public void ss(Book book) {
        System.out.println("收到一条消息 : " + book);
    }
}
