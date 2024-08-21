package com.consumerMessage.rabbitmq.domain.Food;

import java.util.List;

import org.springframework.stereotype.Service;

import com.consumerMessage.rabbitmq.base.BaseService;
import com.consumerMessage.rabbitmq.domain.Food.FoodRecord.FoodRecordResponseDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FoodServiceImpl extends BaseService implements FoodService {

    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public List<FoodRecordResponseDTO> getAllList() {
        var foodList = foodRepository.findAll();
        return FoodMapper.toRecordListDTO(foodList);
    }

    @Override
    @Transactional
    public FoodRecordResponseDTO findById(Integer id) {
        var foodById = foodRepository.findById(id).orElseThrow();

        return FoodMapper.toRecordDTO(foodById);
    }

}
