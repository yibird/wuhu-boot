package com.fly.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.common.model.BaseDO;
import com.fly.mapper.SysRoleMapper;
import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.service.impl.BaseServiceImpl;
import com.fly.service.SysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRoleDO> implements SysRoleService {
    private final SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleDO> getRoles() {
        return sysRoleMapper.selectList(new QueryWrapper());
    }

    @Override
    public int addRole(SysRoleDO sysRoleDO) {
        return sysRoleMapper.insert(sysRoleDO);
    }

    @Override
    public int delRole(Long id) {
        return sysRoleMapper.deleteById(id);
    }
}
