package com.consumerMessage.rabbitmq.domain.Food;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.consumerMessage.rabbitmq.domain.Food.FoodRecord.FoodRecordResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/food")
public class FoodController {

    private final FoodService foodService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<FoodRecordResponseDTO> getAllList() {
        return foodService.getAllList();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public FoodRecordResponseDTO findById(@PathVariable Integer id) {
        return foodService.findById(id);
    }

}
