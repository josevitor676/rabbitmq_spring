package com.consumerMessage.rabbitmq.domain.inventory;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.consumerMessage.rabbitmq.base.BaseService;
import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordResponseDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InventoryServiceImpl extends BaseService implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public List<InventoryRecordResponseDTO> getAll() {
        var inventories = inventoryRepository.findAll();
        return inventories.stream().map((inventory) -> InventoryMapper.toRecordDTO(inventory)).toList();
    }

    @Override
    @Transactional
    public InventoryRecordResponseDTO findById(Integer id) {
        var inventory = inventoryRepository.findById(id).orElseThrow();
        return InventoryMapper.toRecordDTO(inventory);
    }

    @Override
    @Transactional
    public void save(InventoryRecordRequestDTO dto) {
        Inventory inventory = InventoryMapper.toEntity(dto);

        inventoryRepository.save(inventory);
    }

    @Override
    @Transactional
    public void patch(Integer id, InventoryRecordRequestDTO dto) {
        Inventory inventory = InventoryMapper.toEntity(dto);

        var inventoryFind = inventoryRepository.findById(id).orElseThrow();

        BeanUtils.copyProperties(inventory, inventoryFind, this.getNullPropertyNames(inventory));
        inventoryRepository.save(inventoryFind);
    }

}
