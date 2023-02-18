package com.fly.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.mapper.SysRoleMapper;
import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.service.impl.BaseServiceImpl;
import com.fly.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper<SysRoleDO>, SysRoleDO> implements SysRoleService {
    private SysRoleMapper sysRoleMapper;

    @Autowired
    public SysRoleServiceImpl(final SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public List<SysRoleDO> getRoles() {
        System.out.println("sysRoleMapper.getRoles()："+sysRoleMapper.selectList(new QueryWrapper()));
        return new ArrayList<>();
    }
}
