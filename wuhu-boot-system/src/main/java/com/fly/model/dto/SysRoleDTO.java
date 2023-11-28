package com.fly.model.dto;

import com.fly.common.model.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description SysRoleDTO
 * @Author zchengfeng
 * @Date 2023/2/22 8:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "角色DTO模型")
public class SysRoleDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8060716910732643146L;

    @NotNull(message = "角色名称不能为空")
    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String roleName;

    @NotBlank(message = "角色权限不能为空")
    @Schema(description = "角色key", requiredMode = Schema.RequiredMode.REQUIRED)
    private String roleKey;

    @NotNull(message = "角色数据范围不能为空")
    @Range(min = 1, max = 4, message = "角色数据范围超出范围")
    @Schema(description = "数据作用范围", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1:全部数据权限,2:自定义数据权限,3:本部门数据权限,4:本部门及以下数据权限")
    private Integer dataScope;

}
