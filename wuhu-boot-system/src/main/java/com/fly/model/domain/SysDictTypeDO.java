package com.fly.model.domain;


import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @Description: 字典类型DO
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:42:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_dict_type")
public class SysDictTypeDO extends BaseDO<SysDictTypeDO> {
    @Serial
    private static final long serialVersionUID = 3192999476879629708L;

    @Schema(description = "字典名称")
    private String dictName;

    @Schema(description = "字典类型")
    private String dictType;

    @Schema(description = "数据来源(0字典数据,1动态SQL)")
    private int dictSource;

    @Schema(description = "动态sql")
    private String dictSql;

}
