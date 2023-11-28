package com.fly.model.dto;


import com.fly.common.validation.annotation.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 手机号登录DTO
 * @Author zchengfeng
 * @Date 2023/7/03 10:30
 */
@Data
@Schema(description = "手机号登录DTO")
public class SysMobileLoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4963864727242101374L;

    @Schema(description = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    @Phone
    private String mobile;

    @Schema(description = "验证码")
    @NotBlank(message = "验证码不能为空")
    @Length(min = 6, max = 6, message = "验证码错误")
    private String code;
}
