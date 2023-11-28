package com.fly.service.impl;

import com.fly.model.domain.SysUserDO;
import com.fly.service.SysUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {
    @Override
    public UserDetails getUserDetails(SysUserDO sysUserDO) {
        return null;
    }
}
