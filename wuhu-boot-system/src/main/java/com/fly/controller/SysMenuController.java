package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.model.domain.SysMenuDO;
import com.fly.model.query.SysMenuQuery;
import com.fly.model.vo.SysMenuVO;
import com.fly.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

/**
 * @Description 菜单Controller
 * @Author zchengfeng
 * @Date 2023/11/20 17:08
 */
@RestController
@RequestMapping("/v1/sys/menu")
@Tag(name = "菜单控制器")
@AllArgsConstructor
public class SysMenuController {

    private final SysMenuService menuService;

    @GetMapping("/getMenuTree")
    @Operation(summary = "获取菜单树")
    public ApiResult<List<SysMenuVO>> getMenuTree() {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        attributes.setAttribute("name", "zchenfeng", 1);
        return menuService.getMenuTree(1L);
    }

    @GetMapping("/getList")
    @Operation(summary = "获取菜单列表")
    public ApiResult<PageResult<SysMenuDO>> getList(@RequestBody @Valid SysMenuQuery query) {
        return menuService.getList(query);
    }
}
