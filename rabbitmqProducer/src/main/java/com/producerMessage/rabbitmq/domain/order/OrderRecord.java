package com.producerMessage.rabbitmq.domain.order;

import java.time.LocalDateTime;

import lombok.Builder;

public class OrderRecord {

        @Builder
        public record OrderRecordRequestDTO(
                        String name,
                        String quantity,
                        String status,
                        String codOrder) {
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

}
