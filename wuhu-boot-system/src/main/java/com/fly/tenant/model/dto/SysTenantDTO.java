package com.fly.tenant.model.dto;

import com.fly.common.model.dto.BaseDTO;
import com.fly.common.validation.annotation.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTenantDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7059972870796283543L;

    @NotNull(message = "租户名称不能为空")
    @Schema(description = "租户名称")
    private String tenantName;

    @Schema(description = "是否是超级租户(0是,1否)")
    private Boolean superTenant;

    @Schema(description = "地址")
    private String address;

    @Phone(message = "电话输入有误")
    @Schema(description = "电话")
    private String phone;

    @Email(message = "邮箱输入有误")
    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "紧急联系人")
    private String emergencyContact;

}
