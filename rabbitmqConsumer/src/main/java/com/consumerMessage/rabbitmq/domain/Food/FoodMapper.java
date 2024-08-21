package com.consumerMessage.rabbitmq.domain.Food;

import java.util.List;

import com.consumerMessage.rabbitmq.domain.Food.FoodRecord.FoodRecordResponseDTO;

public class FoodMapper {

    public static FoodRecordResponseDTO toRecordDTO(Food entity) {
        if (entity == null) {
            return null;
        } else {
            return FoodRecordResponseDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .calories(entity.getCalories())
                    .gram(entity.getGram())
                    .carbohydrates(entity.getCarbohydrates())
                    .protein(entity.getProtein())
                    .build();
        }
    }

    public static List<FoodRecordResponseDTO> toRecordListDTO(List<Food> entities) {
        return entities.stream().map((entity) -> FoodMapper.toRecordDTO(entity)).toList();
    }

}
