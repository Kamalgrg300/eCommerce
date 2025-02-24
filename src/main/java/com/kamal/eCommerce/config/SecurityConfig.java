package com.kamal.eCommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for the application.
 * Uses the new lambda DSL available in Spring Security 6.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
             // Disable CSRF for simplicity; enable in production
             .csrf(csrf -> csrf.disable())
             // Configure authorization rules
             .authorizeHttpRequests(auth -> auth
                     // Allow unauthenticated access to registration and login endpoints
                     .requestMatchers("/users/register", "/users/login", "/users/register-admin", "/sellers/register").permitAll()
                     // Require authentication for other endpoints
                     .requestMatchers("/products/**", "/cart/**", "/orders/**", "/payments/**").authenticated()
                     // All other requests are permitted
                     .anyRequest().permitAll())
             // Enable HTTP Basic Authentication using defaults
             .httpBasic(Customizer.withDefaults())
             // Configure session management with session fixation protection
             .sessionManagement(session -> session.sessionFixation().migrateSession());

         return http.build();
    }
}
