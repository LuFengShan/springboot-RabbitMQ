package com.gx.ms.config;

import com.gx.ms.entity.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * 配置文件，主要是针对消息的格式的配置
 */
@Configuration
public class MsConfig {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 自定义存入的格式全部为json ，不然就是java序列化的了，这个JSON是引入Bootstrap2默认的Jackson2
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 启动一个线程，每隔5秒生产一条数据，存入和exchange.fanout交换器绑定的，路由规则为guang的队列中
     *
     * @return
     */
    @Bean
    public CommandLineRunner init() {
        return args -> {
            // 任务
            Runnable task = () -> {
                String s = UUID.randomUUID().toString().substring(0, 7);
                rabbitTemplate.convertAndSend("exchange.fanout", "guang", new Book(s, s));
            };
            // 开启一个线程池，只有一个线程
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            // 每5s生产一个对象
            service.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
        };
    }
}
