package com.producerMessage.rabbitmq.domain.order;

import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordResponseDTO;

public class OrderMapper {

    public static Order toEntity(OrderRecordRequestDTO dto) {
        var order = new Order();
        order.setName(dto.name());
        order.setQuantity(dto.quantity());
        order.setStatus(dto.status());
        order.setCodOrder(dto.codOrder());
        return order;
    }

    public static OrderRecordResponseDTO toRecordDTO(Order entity) {
        if (entity == null) {
            return null;
        } else {
            return OrderRecordResponseDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .quantity(entity.getQuantity())
                    .status(entity.getStatus())
                    .codOrder(entity.getCodOrder())
                    .createdAt(entity.getCreatedAt())
                    .build();
        }
    }
}
