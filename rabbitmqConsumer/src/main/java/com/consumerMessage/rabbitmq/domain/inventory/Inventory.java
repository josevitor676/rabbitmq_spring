package com.consumerMessage.rabbitmq.domain.inventory;

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
@Table(name = "inventory")
public class Inventory extends BaseEntity {

    private String quantity;
    private String codOrder;

}
