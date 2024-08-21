package com.producerMessage.rabbitmq.domain.order;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.base.BaseService;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordRequestDTO;
import com.producerMessage.rabbitmq.domain.order.OrderRecord.OrderRecordResponseDTO;
import com.producerMessage.rabbitmq.producer.RabbitmqProducer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl extends BaseService implements OrderService {

    private final OrderRepository orderRepository;
    private final RabbitmqProducer rabbitmqProducer;

    @Override
    @Transactional
    public List<OrderRecordResponseDTO> getAll() {
        var listOrders = orderRepository.findAll();

        return listOrders.stream().map((order) -> OrderMapper.toRecordDTO(order)).toList();
    }

    @Override
    @Transactional
    public OrderRecordResponseDTO findById(Integer id) {
        var order = orderRepository.findById(id).orElseThrow();

        return OrderMapper.toRecordDTO(order);
    }

    @Override
    @Transactional
    public void save(OrderRecordRequestDTO dto) {
        var order = OrderMapper.toEntity(dto);

        order.setStatus("RECEBIDO");
        orderRepository.save(order);

        rabbitmqProducer.sendOrderToQueue(OrderMapper.toRecordDTO(order));
    }

    @Override
    @Transactional
    public void patch(Integer id, OrderRecordRequestDTO dto) {
        var order = OrderMapper.toEntity(dto);

        var orderFind = orderRepository.findById(id).orElseThrow();

        BeanUtils.copyProperties(order, orderFind, this.getNullPropertyNames(order));
        orderRepository.save(orderFind);
    }

    @Override
    @Transactional
    public void patchOrderToProcessing(Integer id) {
        var orderFind = orderRepository.findById(id).orElseThrow();

        orderFind.setStatus("Processado");

        orderRepository.save(orderFind);
    }

}
