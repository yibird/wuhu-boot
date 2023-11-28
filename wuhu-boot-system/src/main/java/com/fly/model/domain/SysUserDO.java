package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.fly.common.validation.annotation.IdCard;
import com.fly.common.validation.annotation.Phone;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:38:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table("sys_user")
@Schema(name = "用户DO模型")
public class SysUserDO extends BaseDO<SysUserDO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -3929824398022233916L;

    @Schema(description = "用户账户")
    private String account;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "性别(0:男,1:女,2:未知)")
    private int sex;

    @Schema(description = "年龄")
    private int age;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "身份证")
    private String idCard;

    @Schema(description = "邮箱", enumAsRef = true)
    private String email;

    @Schema(description = "wechat")
    private String wechat;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "生日")
    private Date birthday;

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "机构id")
    private Long orgId;

    @Schema(description = "岗位id")
    private Long postId;
}
