package com.fly.tenant.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.tenant.model.domain.SysTenantDO;
import com.fly.tenant.model.dto.SysTenantDTO;
import com.fly.tenant.model.query.SysTenantQuery;
import com.fly.tenant.service.SysTenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 租户Controller
 * @Author zchengfeng
 * @Date 2023/11/15 16:08
 */
@RestController
@RequestMapping("/v1/sys/tenant")
@Tag(name = "租户控制器")
@AllArgsConstructor
public class SysTenantController {

    private final SysTenantService tenantService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:tenant:save')")
    @Operation(summary = "添加租户")
    public ApiResult<Void> save(@RequestBody @Valid SysTenantDTO tenantDTO) {
        return tenantService.save(tenantDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:tenant:del')")
    @Operation(summary = "删除租户")
    public ApiResult<Void> del(@Parameter(description = "id数组", required = true)
                               @NotNull(message = "id数组不能为空") List<Long> ids) {
        return tenantService.del(ids);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:tenant:update')")
    @Operation(summary = "更新租户")
    public ApiResult<Void> update(@RequestBody @Valid SysTenantDTO tenantDTO) {
        return tenantService.update(tenantDTO);
    }


    @GetMapping("/getList")
//    @PreAuthorize("hasAuthority('sys:tenant:list')")
    @Operation(summary = "获取租户列表")
    public ApiResult<PageResult<SysTenantDO>> getList(@ParameterObject @Valid SysTenantQuery query) {
        return tenantService.getList(query);
    }

    @GetMapping("/getInfo")
    @PreAuthorize("hasAuthority('sys:tenant:info')")
    @Operation(summary = "获取租户详情")
    public ApiResult<SysTenantDO> getInfo(@NotNull(message = "id不能为空") Long id) {
        return tenantService.getInfo(id);
    }
}
