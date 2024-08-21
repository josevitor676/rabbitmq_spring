package com.producerMessage.rabbitmq.domain.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<OrderRecordResponseDTO> getAll() {
        return orderService.getAll();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public OrderRecordResponseDTO findById(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody OrderRecordRequestDTO dto) {
        orderService.save(dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public void patch(@PathVariable Integer id, @RequestBody OrderRecordRequestDTO dto) {
        orderService.patch(id, dto);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/processing/{id}")
    public void patchOrderToProcessing(@PathVariable Integer id) {
        orderService.patchOrderToProcessing(id);
    }
}
