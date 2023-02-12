package com.fly.common.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Description: 查询公共参数
 * @Author: zchengfeng
 * @Data: 2022/12/6 15:57
 */
@Data
public class BaseQuery {

    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    private Integer page;

    @NotNull(message = "每条页数不能为空")
    @Range(min = 1, max = 1000, message = "每条页数范围为1-1000")
    private Integer limit;
    private Integer order;
}
