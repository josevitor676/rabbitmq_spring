package com.consumerMessage.rabbitmq.domain.Food;

import lombok.Builder;

public class FoodRecord {

    @Builder
    public record FoodRecordResponseDTO(
            Integer id,
            String name,
            String calories,
            String gram,
            String protein,
            String carbohydrates) {
    }

}
