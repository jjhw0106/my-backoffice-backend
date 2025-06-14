package com.my_back_office.auth_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
            .securityMatcher("/**")
            .authorizeHttpRequests(
        auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated())
            .build();
    }
}
