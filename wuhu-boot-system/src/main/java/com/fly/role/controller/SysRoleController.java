package com.fly.role.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.role.model.domain.SysRoleDO;
import com.fly.role.model.dto.SysRoleDTO;
import com.fly.role.model.query.SysRoleQuery;
import com.fly.role.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 角色Controller
 * @Author zchengfeng
 * @Date: 2023-02-12 15:03:55
 */
@RestController
@RequestMapping("/v1/sys/role")
@Tag(name = "角色控制器")
@AllArgsConstructor
public class SysRoleController {

    private final SysRoleService roleService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:role:save')")
    @Operation(summary = "添加角色", method = "POST")
    public ApiResult<Void> save(@Parameter(name = "角色DTO") SysRoleDTO roleDTO) {
        return roleService.save(roleDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:role:del')")
    @Operation(summary = "删除角色", method = "POST")
    public ApiResult<Void> del(@Parameter(description = "id数组", required = true)
                               @NotNull(message = "id数组不能为空") List<Long> ids) {
        return roleService.del(ids);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:role:update')")
    @Operation(summary = "修改角色", method = "POST")
    public ApiResult<Void> update(@Parameter(name = "角色DTO") SysRoleDTO roleDTO) {
        return roleService.update(roleDTO);
    }

    @GetMapping("/getRoleList")
    @PreAuthorize("hasAuthority('sys:role:list')")
    @Operation(summary = "获取角色列表")
    public ApiResult<PageResult<SysRoleDO>> getList(@ParameterObject @Valid SysRoleQuery query) {
        return roleService.getList(query);
    }

    @GetMapping("/getInfo")
    @Operation(summary = "获取详情")
    public ApiResult<SysRoleDO> getInfo(@NotNull(message = "id不能为空") Long id) {
        return roleService.getInfo(id);
    }
}
