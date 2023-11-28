package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.model.dto.SysAccountLoginDTO;
import com.fly.model.dto.SysMobileLoginDTO;
import com.fly.model.vo.SysTokenVO;
import com.fly.service.SysAuthService;
import com.fly.service.SysCaptchaService;
import com.fly.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 授权Controller
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:47
 */
@RestController
@RequestMapping("/v1/sys/auth")
@AllArgsConstructor
@Tag(name = "认证控制器")
public class AuthController {

    private final SysCaptchaService captchaService;
    private final SysAuthService authService;

    @GetMapping("/captcha")
    @Operation(summary = "获取验证码")
    public ApiResult<String> captcha() {
        return captchaService.generate();
    }

    @PostMapping("/sendSMSCode")
    @Operation(summary = "发送短信验证码")
    public int sendCaptcha() {
        return 0;
    }

    @PostMapping("/register")
    @Operation(summary = "注册")
    public int register(@NotBlank String username, @NotBlank String password) {
        return 0;
    }

    @PostMapping("/login")
    @Operation(summary = "账号密码登录")
    public ApiResult<SysTokenVO> login(@RequestBody @Valid SysAccountLoginDTO login) {
        return authService.loginByAccount(login);
    }

    @PostMapping("/mobileLogin")
    @Operation(summary = "手机号登录")
    public ApiResult<SysTokenVO> mobileLogin(@RequestBody @Valid SysMobileLoginDTO login) {
        return authService.loginByMobile(login);
    }

    @PostMapping("/qrCodeLogin")
    @Operation(summary = "扫码登录")
    public int qrCodeLogin() {
        return 0;
    }

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public ApiResult<Void> logout(HttpServletRequest req) {
        return authService.logout(TokenUtils.getAccessToken(req));
    }

}
