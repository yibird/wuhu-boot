package com.fly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 授权Contoller
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:47
 */
@RestController
public class AuthController {
    @GetMapping("/hello")
    public int hello(){
        return 123123;
    }
}
