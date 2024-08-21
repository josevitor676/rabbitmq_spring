package com.consumerMessage.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class Producer {

    public static final String ROUTING_KEY_NAME = "order-updated-routing-key";
    public static final String EXCHANGE_NAME = "order-updated-exchange";

    private final RabbitTemplate rabbitTemplate;

    public void sendOrderUpdated(Integer idOrder) {
        log.info("Ordem Alterada: {}", idOrder);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME, idOrder);
    }

}
