package com.consumerMessage.rabbitmq.domain.Food;

import com.consumerMessage.rabbitmq.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "\"Food\"", schema = "public")
public class Food extends BaseEntity {

    private String name;
    private String calories;
    private String gram;
    private String protein;
    private String carbohydrates;

}
