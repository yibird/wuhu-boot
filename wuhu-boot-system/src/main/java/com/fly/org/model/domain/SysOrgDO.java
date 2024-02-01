package com.fly.org.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 机构DO
 * @Author zchengfeng
 * @Date: 2023-02-12 14:29:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "机构DO模型")
@Table("sys_org")
public class SysOrgDO extends BaseDO<SysOrgDO> {
    @Schema(description = "机构父级id")
    private Long pId;
    @Schema(description = "机构编码")
    private String org_code;
    @Schema(description = "机构名称")
    private String orgName;
    @Schema(description = "机构层级路径(以,号分割机构id,用于优化查找机构)")
    private String level_path;
    @Schema(description = "机构电话")
    private String phone;
    @Schema(description = "机构邮箱")
    private String email;
    @Schema(description = "机构负责人")
    private String leader;
}
