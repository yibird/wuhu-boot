package com.fly.org.model.dto;

import com.fly.common.model.dto.BaseDTO;
import com.fly.common.validation.annotation.Phone;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 机构DTO
 * @Author zchengfeng
 * @Date 2023/3/14 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysOrgDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6393170895308027215L;

    @Schema(description = "机构父级id")
    private Long pid;

    @NotBlank(message = "机构名称不能为空")
    @Schema(description = "机构名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String orgName;

    @Schema(description = "机构id路径,以 - 字符分割")
    private String orgPath;

    @Phone(message = "机构电话格式错误")
    @Schema(description = "机构电话")
    private String phone;

    @Email(message = "邮箱格式错误")
    @Schema(description = "机构邮箱")
    private String email;

    @Schema(description = "机构负责人")
    private String leader;

    @Schema(description = "机构负责人联系电话")
    private String leaderPhone;

    @Range(min = 0, max = 1, message = "启用状态错误")
    @Schema(description = "启用状态,0禁用,1启用", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean status;
}
