package com.fly.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 授权Contoller
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:47
 */
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
