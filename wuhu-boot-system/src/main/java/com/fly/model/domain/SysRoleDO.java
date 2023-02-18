package com.fly.model.domain;
import com.fly.common.model.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @Description: 角色DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 14:46:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleDO extends BaseDO {
    private Long id;
    private String roleName;
    private String roleKey;
    private Integer dataScope;
}
