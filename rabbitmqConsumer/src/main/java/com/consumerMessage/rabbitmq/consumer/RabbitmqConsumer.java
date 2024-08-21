package com.consumerMessage.rabbitmq.consumer;

import org.apache.coyote.BadRequestException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.consumerMessage.rabbitmq.domain.inventory.InventoryRepository;
import com.consumerMessage.rabbitmq.dto.DtoRecord.OrderRecordResponseDTO;
import com.consumerMessage.rabbitmq.feignClient.FeignClientOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitmqConsumer {

    private final FeignClientOrder feignClientOrder;
    private final InventoryRepository inventoryRepository;

    public RabbitmqConsumer(FeignClientOrder feignClientOrder, InventoryRepository inventoryRepository) {
        this.feignClientOrder = feignClientOrder;
        this.inventoryRepository = inventoryRepository;
    }

    @RabbitListener(queues = "order-queue")
    public void listener(OrderRecordResponseDTO dto) {
        log.info("Ordem recebida: {}", dto);

        try {
            log.info("Id da ordem: {}", dto.id());

            var inventoryByCodOrder = inventoryRepository.findByCodOrder(dto.codOrder()).orElseThrow();

            if (Integer.valueOf(dto.quantity()) > Integer.valueOf(inventoryByCodOrder.getCodOrder())) {
                throw new BadRequestException("Erro ao fazer pedido, esse produto não tem no estoque");
            } else {
                feignClientOrder.patchOrderToProcessing(dto.id());
                inventoryByCodOrder.setQuantity(Integer.toString(
                        Integer.valueOf(inventoryByCodOrder.getCodOrder()) - Integer.valueOf(dto.quantity())));

                inventoryRepository.save(inventoryByCodOrder);
            }

            log.info("Ordem alterada para processo: {}", dto);
        } catch (Exception e) {
            log.info("ERRO");
        }

        // try {
        // SimpleMailMessage message = new SimpleMailMessage();
        // message.setFrom("jvss1036@gmail.com");
        // message.setTo("josevitortrabalho90@gmail.com");
        // message.setSubject("PEDIDO RECEBIDO");
        // message.setText(
        // "Um pedido foi recebido: ".concat(dto.name()).concat(" quantidade:
        // ".concat(dto.quantity())));

        // javaMailSender.send(message);

        // } catch (MailException e) {
        // log.error("Erro ao enviar email", e.getMessage());
        // }

    }

}
