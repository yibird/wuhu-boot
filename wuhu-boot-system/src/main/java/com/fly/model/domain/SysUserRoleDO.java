package com.fly.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 用户角色DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:53:52
 * @param: null
 * @return: null
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRoleDO {
    private Long roleId;
    private Long userId;
    private Integer isDefault;
}
