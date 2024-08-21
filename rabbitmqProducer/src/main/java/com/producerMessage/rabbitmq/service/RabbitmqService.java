package com.producerMessage.rabbitmq.service;

import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordRequestDTO;
import com.producerMessage.rabbitmq.producer.RabbitmqProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RabbitmqService {

    private final RabbitmqProducer rabbitmqProducer;

    public void sendMessageToQueue(EmailRecordRequestDTO dto) {
        // rabbitmqProducer.sendMessage(dto);
    }

}
