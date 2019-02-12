package com.freesoft.identity.manager.config;

import com.freesoft.identity.manager.service.KeycloakClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class KeycloakClientTestConfig {

    @Bean
    public KeycloakClient keycloakClient() {
        return mock(KeycloakClient.class);
    }
}
