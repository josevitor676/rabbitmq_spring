package com.producerMessage.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.producerMessage.rabbitmq.domain.order.OrderService;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitmqProducer {

    private final RabbitTemplate rabbitTemplate;

    public static final String ROUTING_KEY_NAME = "order-routing-key";
    public static final String EXCHANGE_NAME = "order-exchange";

    public void sendToken(String token) {
        log.info("Token Enviado: {}", token);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME, token);
    }

    public void sendOrderToQueue(OrderRecordResponseDTO dto) {
        log.info("Ordem Enviada: {}", dto);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME, dto);

    }

}
