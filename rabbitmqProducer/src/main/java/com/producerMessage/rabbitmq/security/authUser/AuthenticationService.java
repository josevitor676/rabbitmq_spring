package com.producerMessage.rabbitmq.security.authUser;

public interface AuthenticationService {

    String submitLogin(LoginDTO dto);

}
