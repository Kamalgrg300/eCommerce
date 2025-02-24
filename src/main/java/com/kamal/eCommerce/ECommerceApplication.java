package com.kamal.eCommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.SpringBootConfiguration;

/**
 * Main application class for the eCommerce service.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    /**
     * This nested static configuration class allows tests (even when they reside
     * in a parent package) to find a valid SpringBootConfiguration.
     */
    @SpringBootConfiguration
    public static class Config {
        // No additional configuration needed.
    }
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
