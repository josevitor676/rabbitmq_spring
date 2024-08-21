package com.producerMessage.rabbitmq.domain.order;

import com.producerMessage.rabbitmq.base.BaseEntity;

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
@Table(schema = "public", name = "order")
public class Order extends BaseEntity {

    private String name;
    private String quantity;
    private String status;
    private String codOrder;

}
