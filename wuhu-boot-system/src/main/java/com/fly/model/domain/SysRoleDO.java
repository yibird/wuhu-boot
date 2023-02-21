package com.fly.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fly.common.model.BaseDO;
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
public class SysRoleDO extends BaseDO {
    @TableId
    private Long id;
    private String roleName;
    private String roleKey;
    private Integer dataScope;
}
