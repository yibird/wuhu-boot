package com.fly.model.query;

import com.fly.common.model.query.BaseQuery;
import com.fly.common.validation.annotation.optional.IntOptional;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 机构查询对象
 * @Author zchengfeng
 * @Date 2023/11/10 11:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDictTypeQuery extends BaseQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 6067715603044545389L;

    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典名称")
    private String dictName;

    @IntOptional(value = {0, 1}, message = "数据来源输入有误")
    @Schema(description = "数据来源(0字典数据,1动态SQL)")
    private int dictSource;
}
