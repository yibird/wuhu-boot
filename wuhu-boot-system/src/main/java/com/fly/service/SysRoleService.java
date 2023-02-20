package com.fly.service;

import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.service.BaseService;

import java.util.List;

public interface SysRoleService extends BaseService<SysRoleDO> {
    List<SysRoleDO> getRoles();
    int addRole(SysRoleDO sysRoleDO);
    int delRole(Long id);
}
