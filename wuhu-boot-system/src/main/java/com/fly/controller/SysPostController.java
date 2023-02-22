package com.fly.controller;

import com.fly.common.model.Result;
import com.fly.model.domain.SysPostDO;
import com.fly.service.SysPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description SysPostController
 * @Author zchengfeng
 * @Date 2023/2/20 19:53
 */
@RestController
@RequestMapping("/sys/post")
@AllArgsConstructor
@Tag(name = "职位控制器")
public class SysPostController {
    private final SysPostService postService;

    @GetMapping("/getList")
    public List<SysPostDO> getList() {
        return null;
    }

    @GetMapping("/getInfo")
    public Result getInfo() {
        return null;
    }

    @PostMapping("/add")
    public Result add() {
        return null;
    }

    @PostMapping("/del")
    public Result del() {
        return null;
    }

    @PostMapping("/update")
    public Result update() {
        return null;
    }
}
