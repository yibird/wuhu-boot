package com.fly.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Description SpringSecurity配置
 * @Author zchengfeng
 * @Date 2023/2/20 14:31
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private final OncePerRequestFilter authenticationTokenFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] permits = new String[0];
        http.addFilterBefore(authenticationTokenFilter, null)
                .authorizeHttpRequests(auth -> auth.requestMatchers(permits).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyRequest().authenticated())
                .headers()
                .frameOptions()
                .disable()
                .and()
                .csrf();
        return http.build();
    }
}
