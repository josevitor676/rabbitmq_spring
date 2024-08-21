package com.producerMessage.rabbitmq.domain.email;

import java.util.List;

import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.base.BaseService;
import com.producerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordResponsetDTO;
import com.producerMessage.rabbitmq.producer.RabbitmqProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService extends BaseService {

    private final EmailRepository emailRepository;

    public void create(EmailRecordRequestDTO dto) {
        var email = EmailMapper.toEntity(dto);

        emailRepository.save(email);
    }

    public List<EmailRecordResponsetDTO> findAll() {
        return emailRepository.findAll().stream().map((entity) -> EmailMapper.toRecordDTO(entity)).toList();
    }

}
