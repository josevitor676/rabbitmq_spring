package com.consumerMessage.rabbitmq.domain.inventory;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordRequestDTO;
import com.consumerMessage.rabbitmq.domain.inventory.InventoryRecord.InventoryRecordResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryRecordResponseDTO> getAll() {
        return inventoryService.getAll();
    }

    @GetMapping("/{id}")
    public InventoryRecordResponseDTO findById(@PathVariable Integer id) {
        return inventoryService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody InventoryRecordRequestDTO dto) {
        inventoryService.save(dto);
    }

    @PatchMapping("/{id}")
    public void patch(@PathVariable Integer id, @RequestBody InventoryRecordRequestDTO dto) {
        inventoryService.patch(id, dto);
    }
}
