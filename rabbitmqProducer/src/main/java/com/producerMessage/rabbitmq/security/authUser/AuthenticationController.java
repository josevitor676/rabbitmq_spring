package com.producerMessage.rabbitmq.security.authUser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/login")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public String login(@RequestBody LoginDTO dto) {
        return authenticationService.submitLogin(dto);
    }

}
