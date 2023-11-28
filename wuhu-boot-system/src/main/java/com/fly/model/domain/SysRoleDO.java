package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.fly.common.validation.annotation.optional.IntOptional;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/***
 * @Description: 角色DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 14:46:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "角色DO模型")
@Table("sys_role")
public class SysRoleDO extends BaseDO<SysRoleDO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 530629313358304777L;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色key")
    private String roleKey;

    @IntOptional(value = {0, 1, 2, 3}, message = "数据范围输入有误")
    @Schema(description = "数据范围", example = "数据范围(0:全部数据权限,1:本部门数据权限,2:本部门及子机构数据权限,3:自定义数据权限)")
    private Integer dataScope;
}
