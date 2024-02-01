package com.fly.dict_data.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 字典类型DO
 * @Author zchengfeng
 * @Date 2023-07-06 15:42:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_dict_data")
@Schema(name = "数据字典")
public class SysDictDataDO extends BaseDO<SysDictDataDO> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6515096994229047618L;

    @Schema(description = "数据字典类型")
    private Long dictType;

    @Schema(description = "数据字典标签")
    private String dictLabel;

    @Schema(description = "数据字典标签值")
    private String dictValue;
}
