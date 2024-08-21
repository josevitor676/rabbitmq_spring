package com.consumerMessage.rabbitmq.domain.Food;

import java.util.List;

import com.consumerMessage.rabbitmq.domain.Food.FoodRecord.FoodRecordResponseDTO;

public interface FoodService {

    List<FoodRecordResponseDTO> getAllList();

    FoodRecordResponseDTO findById(Integer id);

}
