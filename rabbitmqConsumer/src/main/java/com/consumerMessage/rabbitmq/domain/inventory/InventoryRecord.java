package com.consumerMessage.rabbitmq.domain.inventory;

import java.time.LocalDateTime;

import lombok.Builder;

public class InventoryRecord {

    @Builder
    public record InventoryRecordRequestDTO(
            String quantity,
            String codOrder) {
    }

    @Builder
    public record InventoryRecordResponseDTO(
            Integer id,
            LocalDateTime createdAt,
            String quantity,
            String codOrder) {
    }
}
