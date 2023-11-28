package com.fly.service;

import com.fly.model.domain.SysUserDO;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Description 用户详情服务
 * @Author zchengfeng
 * @Date 2023/7/03 15:30
 */
public interface SysUserDetailsService {
    UserDetails getUserDetails(SysUserDO sysUserDO);
}
