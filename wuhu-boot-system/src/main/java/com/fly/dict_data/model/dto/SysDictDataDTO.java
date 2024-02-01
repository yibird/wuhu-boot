package com.fly.dict_data.model.dto;

import com.fly.common.model.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 数据字典DTO
 * @Author zchengfeng
 * @Date: 2023-11-16 15:42:18
 */
@Data
@Schema(description = "数据字典DTO")
public class SysDictDataDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1720476917535680457L;

    @Schema(description = "数据字典类型")
    private Long dictType;

    @Schema(description = "数据字典标签")
    private String dictLabel;

    @Schema(description = "数据字典标签值")
    private String dictValue;
}
