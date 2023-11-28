package com.fly.model.query;

import com.fly.common.model.query.BaseQuery;
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
public class SysDictDataQuery extends BaseQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = -2459518918049258980L;

    @Schema(description = "数据字典类型")
    private Long dictType;

    @Schema(description = "数据字典标签")
    private String dictLabel;

}
