package com.producerMessage.rabbitmq.domain.email;

import com.producerMessage.rabbitmq.base.BaseEntity;

import jakarta.persistence.Column;
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
@Table(name = "email")
public class Email extends BaseEntity {

    @Column(name = "[from]")
    private String from;

    @Column(name = "[to]")
    private String to;

    @Column(name = "[subject]")
    private String subject;

    @Column(name = "[body]")
    private String body;

    @Column(name = "[status]")
    private Boolean status;

}
