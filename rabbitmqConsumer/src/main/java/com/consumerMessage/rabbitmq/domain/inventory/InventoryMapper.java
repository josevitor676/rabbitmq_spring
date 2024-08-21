package com.consumerMessage.rabbitmq.domain.inventory;

import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordResponseDTO;

public class InventoryMapper {

    public static Inventory toEntity(InventoryRecordRequestDTO dto) {
        var inventory = new Inventory();
        inventory.setQuantity(dto.quantity());
        inventory.setCodOrder(dto.codOrder());
        return inventory;
    }

    public static InventoryRecordResponseDTO toRecordDTO(Inventory entity) {
        if (entity == null) {
            return null;
        } else {
            return InventoryRecordResponseDTO.builder()
                    .id(entity.getId())
                    .createdAt(entity.getCreatedAt())
                    .codOrder(entity.getCodOrder())
                    .quantity(entity.getQuantity())
                    .build();
        }
    }

}
