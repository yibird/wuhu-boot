package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.model.domain.SysDictDataDO;
import com.fly.model.dto.SysDictDataDTO;
import com.fly.model.query.SysDictDataQuery;
import com.fly.service.SysDictDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 数据字典Controller
 * @Author zchengfeng
 * @Date 2023/11/16 16:08
 */
@RestController
@RequestMapping("/v1/sys/dictData")
@Tag(name = "数据字典控制器")
@AllArgsConstructor
public class SysDictDataController {

    private final SysDictDataService dictDataService;

    @PostMapping("/save")
//    @PreAuthorize("hasAuthority('sys:dictData:save')")
    @Operation(summary = "添加数据字典", method = "POST")
    public ApiResult<Void> save(@RequestBody @Valid SysDictDataDTO dictDataDTO) {
        return dictDataService.save(dictDataDTO);
    }

    @PostMapping("/del")
    @PreAuthorize("hasAuthority('sys:dictData:del')")
    @Operation(summary = "删除机构", method = "POST")
    public ApiResult<Void> del(@RequestBody List<Long> idList) {
        return dictDataService.del(idList);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:dictData:update')")
    @Operation(summary = "修改数据字典", method = "POST")
    public ApiResult<Void> update(@RequestBody @Valid SysDictDataDTO dictDataDTO) {
        return dictDataService.update(dictDataDTO);
    }

    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('sys:dictData:list')")
    @Operation(summary = "获取数据字典列表")
    public ApiResult<PageResult<SysDictDataDO>> getList(@ParameterObject @Valid SysDictDataQuery query) {
        return dictDataService.getList(query);
    }

    @GetMapping("/getInfo")
    @PreAuthorize("hasAuthority('sys:dictData:info')")
    @Operation(summary = "获取数据字典详情")
    public ApiResult<SysDictDataDO> info(Long id) {
        return dictDataService.getInfo(id);
    }
}
