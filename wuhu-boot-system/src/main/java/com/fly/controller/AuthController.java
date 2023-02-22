package com.fly.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 授权Contoller
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:47
 */
@RestController
@RequestMapping("/sys/auth")
@AllArgsConstructor
@Tag(name = "认证控制器")
public class AuthController {
    @GetMapping("/hello")
    public int hello() {
        return 123123;
    }

    @GetMapping("/getCaptcha")
    @Operation(summary = "获取验证码")
    public int captcha() {
        return 0;
    }

    @PostMapping("/sendSMSCode")
    @Operation(summary = "发送短信验证码")
    public int sendCaptcha() {
        return 0;
    }

    @PostMapping("/register")
    @Operation(summary = "注册")
    public int register() {
        return 0;
    }

    @PostMapping("/login")
    @Operation(summary = "账号密码登录")
    public int login() {
        return 0;
    }

    @PostMapping("/mobileLogin")
    @Operation(summary = "手机号登录")
    public int mobileLogin() {
        return 0;
    }

    @PostMapping("/qrCodeLogin")
    @Operation(summary = "扫码登录")
    public int qrCodeLogin() {
        return 0;
    }

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public int logout() {
        return 0;
    }
}
