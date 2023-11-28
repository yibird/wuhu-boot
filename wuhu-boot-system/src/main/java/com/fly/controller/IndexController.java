package com.fly.controller;

import com.fly.common.model.response.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: IndexController
 * @Author: zchengfeng
 * @Data: 2023/12/6 16:47
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public ApiResult<Void> index() {
        return ApiResult.okWithMessage("欢迎使用Wuhu-boot!");
    }
    @GetMapping("/hello")
    public ApiResult<Void> hello() {
        return ApiResult.okWithMessage("hello");
    }
}
