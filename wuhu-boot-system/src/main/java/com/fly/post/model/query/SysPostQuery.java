package com.fly.post.model.query;

import com.fly.common.model.query.BaseQuery;
import com.fly.common.validation.annotation.optional.IntOptional;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPostQuery extends BaseQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 5173151466306493250L;

    @Schema(description = "岗位编码")
    private String postCode;

    @Schema(description = "岗位名称")
    private String postName;

    @IntOptional(value = {0, 1, 2, 3}, message = "岗位类型输入有误")
    @Schema(description = "岗位类型(0全职岗位、1试用岗位、2实习岗位、3临时岗位)")
    private int postType;

//    @IntOptional(value = {0, 1, 2, 3, 4, 5, 6}, message = "岗位等级输入有误")
    @Schema(description = "岗位等级(0实习、1初级、2中级、3高级、4资深、5专家、6首席官)")
    private int postLevel;

}
