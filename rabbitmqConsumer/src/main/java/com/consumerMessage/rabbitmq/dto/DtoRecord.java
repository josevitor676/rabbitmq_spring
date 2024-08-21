package com.consumerMessage.rabbitmq.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;

public class DtoRecord {

        @Builder
        public record DtoRecordRequest(
                        String name,
                        String email,
                        Integer age,
                        LocalDate birthDate) {
        }

        @Builder
        public record EmailRecordRequestDTO(
                        String from,
                        String to,
                        String subject,
                        String body,
                        Boolean status) {
        }

        @Builder
        public record OrderRecordResponseDTO(
                        Integer id,
                        String name,
                        String quantity,
                        String status,
                        String codOrder,
                        LocalDateTime createdAt) {
        }

        @Builder
        public record OrderRecordRequestDTO(
                        String name,
                        String quantity,
                        String status,
                        String codOrder) {
        }

}