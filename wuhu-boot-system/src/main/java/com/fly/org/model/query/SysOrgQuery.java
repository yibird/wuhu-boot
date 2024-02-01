package com.fly.org.model.query;

import com.fly.common.model.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 机构查询对象
 * @Author zchengfeng
 * @Date 2023/3/17 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysOrgQuery extends BaseQuery {

    @Schema(description = "机构名称")
    private String orgName;
}
