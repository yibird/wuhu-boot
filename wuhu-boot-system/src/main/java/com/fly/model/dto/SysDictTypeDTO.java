package com.fly.model.dto;

import com.fly.common.model.dto.BaseDTO;
import com.fly.common.validation.annotation.optional.IntOptional;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description: 字典类型DTO
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:42:18
 */
@Data
@Schema(description = "字典类型DTO")
public class SysDictTypeDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1720476917535680457L;

    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典名称")
    private String dictName;

    @IntOptional(value = {0, 1}, message = "数据来源输入有误")
    @Schema(description = "数据来源(0字典数据,1动态SQL)")
    private int dictSource;

    @Schema(description = "动态sql")
    private String dictSql;
}
