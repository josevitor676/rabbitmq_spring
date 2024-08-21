package com.consumerMessage.rabbitmq.domain.inventory;

import java.util.List;

import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordResponseDTO;

public interface InventoryService {

    List<InventoryRecordResponseDTO> getAll();

    InventoryRecordResponseDTO findById(Integer id);

    void save(InventoryRecordRequestDTO dto);

    void patch(Integer id, InventoryRecordRequestDTO dto);

}
