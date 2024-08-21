package com.consumerMessage.rabbitmq.helper;

import java.io.IOException;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RestClientProducer extends RestClient {

    public RestClientProducer(Environment environment) {
        super(environment.getProperty("spring.url.api-producer"), List.of("Content-Type", "application/json"));

    }

    public void patchOrderToProcessing(String id) {
        try {
            patchNoBody("order/".concat(id));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
