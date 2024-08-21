package com.producerMessage.rabbitmq.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableRetry
@EnableJpaAuditing
@EnableAsync
@RequiredArgsConstructor
public class MvcConfiguration {

    @Bean
    CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);

        config.addAllowedHeader("*");

        config.addAllowedMethod("*");

        // CORS configurado no azure WebApp
        config.setAllowedOriginPatterns(List.of("*"));

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}