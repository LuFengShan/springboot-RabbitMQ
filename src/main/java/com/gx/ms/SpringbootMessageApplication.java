package com.gx.ms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * {@link org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration} ： 引入ampq依赖以后，会自动加载RabbitAmqp的配置
 * <p>
 * {@link org.springframework.amqp.rabbit.core.RabbitTemplate} ：提供了操作RabbitAMQP的模板和JdbcTemplate模板类似
 * <p>
 * {@link com.rabbitmq.client.ConnectionFactory} ：提供了连接RabbitAMQP的服务的连接工厂
 * <p>
 * {@link org.springframework.amqp.core.AmqpAdmin} ：提供了监听RabbitAMQP的消息实现
 * <p>
 * {@link EnableRabbit} ：如果要开启订阅消息，则必须使用这个
 */
@EnableRabbit// 开启注解的RabbitMQ模式，主要是为了监听队列中的消息，以便取出消息
@SpringBootApplication
public class SpringbootMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMessageApplication.class, args);
    }

}
