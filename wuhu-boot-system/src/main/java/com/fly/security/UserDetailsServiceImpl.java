package com.fly.security;

import com.fly.convert.SysUserConvert;
import com.fly.mapper.SysUserMapper;
import com.fly.model.domain.SysUserDO;
import com.fly.service.SysMenuService;
import com.fly.user.UserDetail;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SysUserMapper userMapper;
    private final SysMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysUserDO sysUserDO = userMapper.getByAccount(account);
        if (sysUserDO == null) throw new UsernameNotFoundException("用户不存在");
        // 1.SysUserDO转为UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertUserDetail(sysUserDO);
        userDetail.setEnabled(sysUserDO.getStatus());
        // 3.设置用户权限列表
//        Set<String> authoritySet = menuService.getUserAuthoritySet(userDetail.getId());
        userDetail.setAuthoritySet(new HashSet<>());
        return userDetail;
    }
}
