package com.fly.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import java.util.Date;

/**
 * @Description: 基础实体类, 包含了实体类通用字段
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDO {
    @Schema(description = "排序序号")
    @Range(min = 0, max = 99999)
    private Integer orderNum;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "删除标识(0:未删除,1:已删除)")
    private Integer delFlag;

    @Schema(description = "创建人")
    private String createBy;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "修改人")
    private String updateBy;

    @Schema(description = "修改时间")
    private Date updateTime;
}
