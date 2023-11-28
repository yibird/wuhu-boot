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
 * @Date 2023/3/17 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleQuery extends BaseQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = -7392346166957581689L;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "角色名称")
    private String roleName;
}
