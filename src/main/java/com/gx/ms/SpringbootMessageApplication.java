package com.gx.ms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * {@link org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration}
 * {@link org.springframework.amqp.rabbit.core.RabbitTemplate}
 * {@link com.rabbitmq.client.ConnectionFactory}
 * {@link org.springframework.amqp.core.AmqpAdmin}
 * {@link EnableRabbit}
 */
@EnableRabbit// 开启注解的RabbitMQ模式
@SpringBootApplication
public class SpringbootMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMessageApplication.class, args);
    }

}
