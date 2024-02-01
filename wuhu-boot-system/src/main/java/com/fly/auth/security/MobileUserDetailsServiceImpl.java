//package com.fly.security;
//
//import com.fly.mapper.SysUserMapper;
//import com.fly.model.domain.SysUserDO;
//import com.fly.security.mobile.MobileUserDetailsService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * @Description 手机用户详细信息服务实现类,根据手机号获取 UserDetails
// * @Author zchengfeng
// * @Date 2023/6/19 14:31
// */
//@Service
//@AllArgsConstructor
//public class MobileUserDetailsServiceImpl implements MobileUserDetailsService {
//    private final SysUserMapper sysUserMapper;
//    @Override
//    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
//        SysUserDO sysUserDO = sysUserMapper.getByMobile(mobile);
//        if (sysUserDO == null) throw new UsernameNotFoundException("手机号错误");
//        return null;
//    }
//}
