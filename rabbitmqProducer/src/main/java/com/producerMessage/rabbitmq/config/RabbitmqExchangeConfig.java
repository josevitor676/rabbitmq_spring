package com.producerMessage.rabbitmq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RabbitmqExchangeConfig {

    public static final String EXCHANGE_NAME = "order-exchange";

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

}
