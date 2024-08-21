package com.producerMessage.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RabbitmqConfig {

    private final DirectExchange directExchange;

    public static final String QUEUE_NAME = "order-queue";
    public static final String ROUTING_KEY_NAME = "order-routing-key";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange)
                .with(ROUTING_KEY_NAME);
    }

}