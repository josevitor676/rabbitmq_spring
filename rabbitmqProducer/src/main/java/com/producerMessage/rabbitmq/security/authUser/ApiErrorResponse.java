package com.producerMessage.rabbitmq.security.authUser;

public record ApiErrorResponse(
        int errorCode,
        String description) {
}
