package com.producerMessage.rabbitmq.domain.users;

import lombok.Builder;

public class UsersRecord {

    @Builder
    public record UsersRecordResponseDTO(
            String id,
            String name,
            String email,
            String image,
            String password,
            String firstName,
            String lastName) {
    }

}
