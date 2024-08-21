package com.consumerMessage.rabbitmq.security.authUser;

public record ApiErrorResponse(
        int errorCode,
        String description) {
}
