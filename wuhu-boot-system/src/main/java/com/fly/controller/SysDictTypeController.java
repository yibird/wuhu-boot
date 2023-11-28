package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.model.domain.SysDictTypeDO;
import com.fly.model.dto.SysDictTypeDTO;
import com.fly.model.query.SysDictTypeQuery;
import com.fly.service.SysDictTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 字典类型Controller
 * @Author zchengfeng
 * @Date 2023/11/16 16:08
 */
@RestController
@RequestMapping("/v1/sys/dictType")
@Tag(name = "字典类型控制器")
@AllArgsConstructor
public class SysDictTypeController {

    private final SysDictTypeService dictTypeService;

    @PostMapping("/save")
//    @PreAuthorize("hasAuthority('sys:dictType:save')")
    @Operation(summary = "添加字典类型", method = "POST")
    public ApiResult<Void> save(@RequestBody @Valid SysDictTypeDTO dictTypeDTO) {
        return dictTypeService.save(dictTypeDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:dictType:del')")
    @Operation(summary = "删除机构", method = "POST")
    public ApiResult<Void> del(@RequestBody List<Long> idList) {
        return dictTypeService.del(idList);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:dictType:update')")
    @Operation(summary = "修改数据字典", method = "POST")
    public ApiResult<Void> update(@RequestBody @Valid SysDictTypeDTO dictTypeDTO) {
        return dictTypeService.update(dictTypeDTO);
    }

    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('sys:dictType:list')")
    @Operation(summary = "获取字典分类列表")
    public ApiResult<PageResult<SysDictTypeDO>> getList(@ParameterObject @Valid SysDictTypeQuery query) {
        return dictTypeService.getList(query);
    }

    @GetMapping("/getInfo")
    @PreAuthorize("hasAuthority('sys:dictType:info')")
    @Operation(summary = "获取字典分类详情")
    public ApiResult<SysDictTypeDO> info(Long id) {
        return dictTypeService.getInfo(id);
    }

}
