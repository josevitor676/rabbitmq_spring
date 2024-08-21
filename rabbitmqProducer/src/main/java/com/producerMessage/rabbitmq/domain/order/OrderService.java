package com.producerMessage.rabbitmq.domain.order;

import java.util.List;

import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordResponseDTO;

public interface OrderService {

    List<OrderRecordResponseDTO> getAll();

    OrderRecordResponseDTO findById(Integer id);

    void save(OrderRecordRequestDTO dto);

    void patch(Integer id, OrderRecordRequestDTO dto);

    void patchOrderToProcessing(Integer id);

}
