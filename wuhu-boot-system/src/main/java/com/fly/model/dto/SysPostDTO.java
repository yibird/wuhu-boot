package com.fly.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * @Description 岗位DTO
 * @Author zchengfeng
 * @Date 2023/2/20 19:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPostDTO {

    @NotNull(message = "职务编码不能为空")
    private String postCode;

    @NotNull(message = "职务编码不能为空")
    private String postName;

    @Range(min = 1,max = 7,message = "职务级别错误")
    private String postLevel;
}
