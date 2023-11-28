package com.fly.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 账号登录DTO
 * @Author zchengfeng
 * @Date 2023/7/03 10:30
 */
@Data
@Schema(description = "账号登录DTO")
public class SysAccountLoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7325487253257643468L;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "账号")
    private String account;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "验证码不能为空")
    @Schema(description = "验证码")
    private String captcha;
}
