package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @Description: 租户DO
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:42:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "租户DO模型")
@Table("sys_tenant")
public class SysTenantDO extends BaseDO<SysTenantDO> {

    @Serial
    private static final long serialVersionUID = -8264551088720237835L;

    @Schema(description = "租户名称")
    private String tenantName;

    @Schema(description = "是否是超级租户(0是,1否)")
    private Boolean superTenant;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "紧急联系人")
    private String emergencyContact;
}
