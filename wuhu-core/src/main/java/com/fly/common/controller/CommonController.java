package com.fly.common.controller;

import com.fly.common.model.response.ApiResult;
import com.fly.common.utils.TokenUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
@AllArgsConstructor
@Tag(name = "通用控制器")
public class CommonController {

    @GetMapping("/generateToken")
    public ApiResult<String> hello() {
        return ApiResult.ok(TokenUtils.generate());
    }
}
