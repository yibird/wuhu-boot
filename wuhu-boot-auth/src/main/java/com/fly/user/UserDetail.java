package com.fly.user;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description 用户信息类
 * @Author zchengfeng
 * @Date 2023/6/8 14:31
 */
@Data
public class UserDetail implements UserDetails, Serializable {
    @Serial
    private static final long serialVersionUID = 3754338199444312729L;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 帐户是否过期
     */
    private boolean isAccountNonExpired;
    /**
     * 账户是否被锁定
     */
    private boolean isAccountNonLocked;
    /**
     * 凭证是否过期
     */
    private boolean isCredentialsNonExpired;
    /**
     * 账户是否可用
     */
    private boolean isEnabled;
    /**
     * 拥有权限集合
     */
    private Set<String> authoritySet;

    /**
     * 返回用户所属权限集合
     *
     * @return 权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritySet.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
