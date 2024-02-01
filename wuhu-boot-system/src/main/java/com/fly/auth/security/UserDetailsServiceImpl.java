package com.fly.auth.security;

import com.fly.menu.service.SysMenuService;
import com.fly.user.UserDetail;
import com.fly.user.convert.SysUserConvert;
import com.fly.user.mapper.SysUserMapper;
import com.fly.user.model.domain.SysUserDO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @Description 2023-11-30 23:39:11
 * @Author zchengfeng
 * @Date 2023-11-30 23:39:11
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SysUserMapper userMapper;
    private final SysMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysUserDO sysUserDO = userMapper.getByAccount(account);
        if (sysUserDO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 1.SysUserDO转为UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertUserDetail(sysUserDO);
        userDetail.setEnabled(sysUserDO.getStatus());
        // 3.设置用户权限列表
//        Set<String> authoritySet = menuService.getUserAuthoritySet(userDetail.getId());
        userDetail.setAuthoritySet(new HashSet<>());
        return userDetail;
    }
}
