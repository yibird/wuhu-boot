package com.fly.org.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.org.model.domain.SysOrgDO;
import com.fly.org.model.dto.SysOrgDTO;
import com.fly.org.model.query.SysOrgQuery;
import com.fly.org.service.SysOrgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 机构Controller
 * @Author zchengfeng
 * @Date 2023/3/17 16:08
 */
@RestController
@RequestMapping("/v1/sys/org")
@AllArgsConstructor
@Tag(name = "机构控制器")
public class SysOrgController {

    private final SysOrgService orgService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:org:save')")
    @Operation(summary = "添加机构", method = "POST")
    public ApiResult<Void> save(@RequestBody @Valid SysOrgDTO orgDTO) {
        return orgService.save(orgDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:org:del')")
    @Operation(summary = "删除机构", method = "POST")
    public ApiResult<Void> del(@RequestBody List<Long> idList) {
        return orgService.del(idList);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:org:update')")
    @Operation(summary = "修改机构", method = "POST")
    public ApiResult<Void> update(@RequestBody @Valid SysOrgDTO orgDTO) {
        return orgService.update(orgDTO);
    }

    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('sys:org:list')")
    @Operation(summary = "获取机构列表")
    public ApiResult<PageResult<SysOrgDO>> getList(@ParameterObject @Valid SysOrgQuery query) {
        return orgService.getList(query);
    }

    @GetMapping("/getInfo")
    @PreAuthorize("hasAuthority('sys:org:info')")
    @Operation(summary = "获取机构详情")
    public ApiResult<SysOrgDO> info(Long id) {
        return orgService.getInfo(id);
    }
}
