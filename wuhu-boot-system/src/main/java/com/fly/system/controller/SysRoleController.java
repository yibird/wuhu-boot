package com.fly.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 角色控制器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:03:55
 */
@RequestMapping("/sys/role")
@RestController
public class SysRoleController {

    @GetMapping("/getRoleList")
    public void getRoleList() {

    }
}
