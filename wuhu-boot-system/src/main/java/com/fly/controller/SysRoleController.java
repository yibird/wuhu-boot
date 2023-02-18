package com.fly.controller;

import com.fly.model.domain.SysRoleDO;
import com.fly.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 角色控制器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:03:55
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    private SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(final SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/getRoles")
    public List<SysRoleDO> getRoles() {
        return sysRoleService.getRoles();
    }

    @PostMapping("/delRole")
    public String delRole() {
        return "";
    }
}
