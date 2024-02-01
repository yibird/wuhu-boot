package com.fly.menu.model.query;

import com.fly.common.model.query.BaseQuery;
import com.fly.common.validation.annotation.optional.IntOptional;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 菜单查询对象
 * @Author zchengfeng
 * @Date 2023/11/12 15:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuQuery extends BaseQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 7217732738404255303L;

    @Schema(description = "菜单父级id(0表示一级菜单)", defaultValue = "0")
    private Long pId;

    @Schema(description = "菜单编码")
    private String menuCode;

    @Schema(description = "菜单名称")
    private String menuName;

    @IntOptional(value = {0, 1, 2}, message = "菜单类型输入有误")
    @Schema(description = "菜单类型(0:目录,1:菜单,2:按钮)")
    private int menuType;
}
