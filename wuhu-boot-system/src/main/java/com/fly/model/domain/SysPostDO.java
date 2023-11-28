package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description: 职位DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:41:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "岗位DO模型")
@Table("sys_post")
public class SysPostDO extends BaseDO<SysPostDO> implements Serializable {
    @Serial
    private static final long serialVersionUID = 6653394142652821626L;

    @Schema(description = "岗位编码")
    private String postCode;

    @Schema(description = "岗位名称")
    private String postName;

    @Schema(description = "岗位类型(0全职岗位、1试用岗位、2实习岗位、3临时岗位)")
    private int postType;

    @Schema(description = "岗位等级(0实习、1初级、2中级、3高级、4资深、5专家、6首席官)")
    private int postLevel;
}
