package com.fly.common.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.validator.constraints.Range;


/**
 * @Description 查询公共参数
 * @Author zchengfeng
 * @Author 2022/12/6 15:57
 */
@Getter
@ToString
public class BaseQuery {

    @Min(value = 1, message = "分页页码不能小于1")
    @Schema(description = "当前页码")
    private Integer current;

    @Range(min = 1, max = 1000, message = "每条页数范围为1-1000")
    @Schema(description = "当前页码显示条数")
    private Integer pageSize;

    public BaseQuery() {
        this.current = 1;
        this.pageSize = 10;
    }

    public BaseQuery(Integer current, Integer pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public void setCurrent(Integer current) {
        this.current = current == null || current <= 0 ? 1 : current;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = 10;
            return;
        }
        this.pageSize = pageSize <= 0 || pageSize > 1000 ? 1000 : pageSize;
    }
}
