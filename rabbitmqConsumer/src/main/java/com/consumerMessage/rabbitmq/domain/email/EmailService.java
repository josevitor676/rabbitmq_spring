package com.consumerMessage.rabbitmq.domain.email;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordResponsetDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService extends com.consumerMessage.rabbitmq.base.BaseService {

    private final EmailRepository emailRepository;

    public void create(EmailRecordRequestDTO dto) {
        var email = EmailMapper.toEntity(dto);

        emailRepository.save(email);
    }

    public List<EmailRecordResponsetDTO> findAll() {
        return emailRepository.findAll().stream().map((entity) -> EmailMapper.toRecordDTO(entity)).toList();
    }

    public EmailRecordResponsetDTO findById(Integer id) {
        return EmailMapper.toRecordDTO(emailRepository.findById(id).orElseThrow());
    }
}
