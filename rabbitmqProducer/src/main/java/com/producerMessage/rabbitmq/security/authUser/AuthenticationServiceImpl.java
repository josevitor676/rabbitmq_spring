package com.producerMessage.rabbitmq.security.authUser;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.base.BaseService;
import com.producerMessage.rabbitmq.producer.RabbitmqProducer;
import com.producerMessage.rabbitmq.security.TokenService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl extends BaseService implements AuthenticationService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final RabbitmqProducer rabbitmqProducer;

    @Override
    @Transactional
    public String submitLogin(LoginDTO dto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.email, dto.password));

        var token = tokenService.generateToken(dto.email);

        // rabbitmqProducer.sendToken(token);

        return token;
    }

}
