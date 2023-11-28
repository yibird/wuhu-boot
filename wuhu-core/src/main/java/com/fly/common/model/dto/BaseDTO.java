package com.fly.common.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    @Schema(description = "id")
    private Integer id;

    @Schema(description = "备注")
    private String remark;
}
