package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.model.domain.SysPostDO;
import com.fly.model.dto.SysPostDTO;
import com.fly.model.query.SysPostQuery;
import com.fly.service.SysPostService;
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
 * @Description 岗位Controller
 * @Author zchengfeng
 * @Date 2023/2/20 19:53
 */
@RestController
@RequestMapping("/v1/sys/post")
@AllArgsConstructor
@Tag(name = "职位控制器")
public class SysPostController {

    private final SysPostService postService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sys:post:save')")
    @Operation(summary = "添加岗位")
    public ApiResult<Void> save(@RequestBody @Valid SysPostDTO sysPostDTO) {
        return postService.save(sysPostDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:post:del')")
    @Operation(summary = "删除岗位")
    public ApiResult<Void> del(@Parameter(description = "id数组", required = true)
                               @NotNull(message = "id数组不能为空") List<Long> ids) {
        return postService.del(ids);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:post:update')")
    @Operation(summary = "更新岗位")
    public ApiResult<Void> update(@RequestBody @Valid SysPostDTO sysPostDTO) {
        return postService.update(sysPostDTO);
    }

    @GetMapping("/getList")
//    @PreAuthorize("hasAuthority('sys:post:list')")
    @Operation(summary = "获取岗位列表")
    public ApiResult<PageResult<SysPostDO>> getList(@ParameterObject @Valid SysPostQuery query) {
        return postService.getList(query);
    }

    @GetMapping("/getInfo")
    @PreAuthorize("hasAuthority('sys:post:info')")
    @Operation(summary = "获取岗位详情")
    public ApiResult<SysPostDO> getInfo(@NotNull(message = "id不能为空") Long id) {
        return postService.getInfo(id);
    }
}
