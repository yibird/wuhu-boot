package com.fly.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户Controller
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:48
 */
@RestController
@RequestMapping("/v1/sys/user")
@Tag(name = "用户控制器")
@AllArgsConstructor
public class SysUserController {

}
