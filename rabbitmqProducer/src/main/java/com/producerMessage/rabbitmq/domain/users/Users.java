package com.producerMessage.rabbitmq.domain.users;

import com.producerMessage.rabbitmq.base.BaseEntityString;

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
@Table(name = "users")
public class Users extends BaseEntityString {

    private String name;
    private String email;
    private String image;
    private String password;
    private String firstName;
    private String lastName;

}
