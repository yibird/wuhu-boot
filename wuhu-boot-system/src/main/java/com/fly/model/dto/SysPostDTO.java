package com.fly.model.dto;

import com.fly.common.model.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 岗位DTO
 * @Author zchengfeng
 * @Date 2023/2/20 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPostDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1230430528053286874L;

    @NotNull(message = "职务编码不能为空")
    @Schema(description = "岗位编码")
    private String postCode;

    @NotNull(message = "职务编码不能为空")
    @Schema(description = "岗位名称")
    private String postName;

    @Schema(description = "岗位类型(0全职岗位、1试用岗位、2实习岗位、3临时岗位)")
    @Range(min = 0, max = 3, message = "岗位类型错误")
    private Integer postType;

    @NotNull(message = "岗位级别不能为空")
    @Range(min = 0, max = 6, message = "岗位级别错误")
    @Schema(description = "岗位级别(0实习、1初级、2中级、3高级、4资深、5专家、6首席官)")
    private Integer postLevel;

    @Schema(description = "备注")
    private String remark;
}
