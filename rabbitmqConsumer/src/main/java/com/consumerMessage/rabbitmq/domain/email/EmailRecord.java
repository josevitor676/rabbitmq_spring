package com.consumerMessage.rabbitmq.domain.email;

import lombok.Builder;

public class EmailRecord {

    @Builder
    public record EmailRecordRequestDTO(
            String from,
            String to,
            String subject,
            String body,
            Boolean status) {
    }

    @Builder
    public record EmailRecordResponsetDTO(
            Integer id,
            String from,
            String to,
            String subject,
            String body,
            Boolean status) {
    }

}