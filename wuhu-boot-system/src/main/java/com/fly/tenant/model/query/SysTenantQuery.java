package com.fly.tenant.model.query;

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
 * @Date 2023/11/13 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysTenantQuery extends BaseQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = -7322128554445067461L;

    @Schema(description = "机构编码")
    private String tenantCode;

    @Schema(description = "机构名称")
    private String tenantName;
}
