package com.consumerMessage.rabbitmq.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.consumerMessage.rabbitmq.config.FeignConfig;
import com.consumerMessage.rabbitmq.dto.DtoRecord.OrderRecordRequestDTO;

@FeignClient(name = "order-service", url = "http://localhost:8080/api/v1", configuration = FeignConfig.class)
public interface FeignClientOrder {

    @PatchMapping("/order/processing/{id}")
    void patchOrderToProcessing(@PathVariable("id") Integer id);

    @PatchMapping("/order/{id}")
    void patch(@PathVariable("id") Integer id, @RequestBody OrderRecordRequestDTO dto);
}