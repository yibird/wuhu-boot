//package com.fly.security.config;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.filter.OncePerRequestFilter;
//
///**
// * @Description SpringSecurity配置
// * @Author zchengfeng
// * @Date 2023/2/20 14:31
// */
//@Configuration
//@AllArgsConstructor
//@EnableWebSecurity
//@EnableMethodSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .requestMatchers("/swagger-ui.html","/swagger-resources/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .headers()
//                .frameOptions()
//                .disable()
//                .and()
//                .csrf()
//                .and()
//                .cors();
//        return http.build();
//    }
//}
