package com.fly.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * @Description SysRoleDTO
 * @Author zchengfeng
 * @Date 2023/2/22 8:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "角色DTO模型")
public class SysRoleDTO {
    @Schema(description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色名称不能为空")
    private String roleName;

    @Schema(description = "角色key", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色权限不能为空")
    private String roleKey;

    @Schema(description = "数据作用范围", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1:全部数据权限,2:自定义数据权限,3:本部门数据权限,4:本部门及以下数据权限")
    @NotNull(message = "角色数据范围不能为空")
    @Range(min = 1, max = 4, message = "角色数据范围超出范围")
    private Integer dataScope;

    @Schema(description = "排序序号")
    private Integer orderNum;

    @Schema(description = "备注")
    private String remark;
}
