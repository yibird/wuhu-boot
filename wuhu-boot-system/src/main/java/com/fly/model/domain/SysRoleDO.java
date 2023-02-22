package com.fly.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fly.common.model.BaseDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @Description: 角色DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 14:46:04
 */
@TableName("sys_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "角色DO模型")
public class SysRoleDO extends BaseDO {
    @TableId
    @Schema(description = "角色id")
    private Long id;
    @Schema(description = "角色名称")
    private String roleName;
    @Schema(description = "角色key")
    private String roleKey;
    @Schema(description = "数据作用范围", example = "1:全部数据权限,2:自定义数据权限,3:本部门数据权限,4:本部门及以下数据权限")
    private Integer dataScope;
}
