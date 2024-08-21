package com.consumerMessage.rabbitmq.domain.email;

import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.email.EmailRecord.EmailRecordResponsetDTO;

public class EmailMapper {

    public static Email toEntity(EmailRecordRequestDTO dto) {
        var email = new Email();
        email.setFrom(dto.from());
        email.setTo(dto.to());
        email.setSubject(dto.subject());
        email.setBody(dto.body());
        email.setStatus(dto.status());
        return email;
    }

    public static EmailRecordResponsetDTO toRecordDTO(Email entity) {
        return EmailRecordResponsetDTO.builder()
                .id(entity.getId())
                .from(entity.getFrom())
                .to(entity.getTo())
                .subject(entity.getSubject())
                .body(entity.getBody())
                .status(entity.getStatus())
                .build();
    }

}