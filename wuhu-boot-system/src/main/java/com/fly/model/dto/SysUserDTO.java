package com.fly.model.dto;

import com.fly.common.model.dto.BaseDTO;
import com.fly.common.validation.annotation.IdCard;
import com.fly.common.validation.annotation.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description SysOrgDTO
 * @Author zchengfeng
 * @Date 2023/3/14 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -891681951091277132L;

    @NotBlank(message = "账户不能为空")
    @Schema(description = "用户账户")
    private String account;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

    @NotBlank(message = "用户昵称为空")
    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "性别(0:男,1:女,2:未知)")
    private int sex;

    @Schema(description = "年龄")
    @Range(min = 0, max = 120, message = "年龄输入有误")
    private int age;

    @Phone(message = "手机号输入有误")
    @Schema(description = "手机号")
    private String phone;

    @IdCard(message = "身份证输入有误")
    @Schema(description = "身份证")
    private String idCard;

    @Email(message = "邮箱格式错误")
    @Schema(description = "邮箱", enumAsRef = true)
    private String email;

    @Schema(description = "wechat")
    private String wechat;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "头像")
    private String avatar;

    @Past(message = "生日输入有误")
    @Schema(description = "生日")
    private Date birthday;

    @NotNull(message = "角色不能为空")
    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "机构id")
    private Long orgId;

    @Schema(description = "岗位id")
    private Long postId;

}
