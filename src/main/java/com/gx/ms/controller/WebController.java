package com.gx.ms.controller;

import com.gx.ms.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/message")
    public String message() {
        Book book = new Book("aa", "bb");
        rabbitTemplate.convertAndSend("exchange.direct", "guang.xu", book);
        return book.toString();
    }
}
