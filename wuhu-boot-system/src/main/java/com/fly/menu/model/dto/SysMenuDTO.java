package com.fly.menu.model.dto;

import com.fly.common.model.dto.BaseDTO;
import com.fly.common.validation.annotation.optional.IntOptional;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 菜单DTO
 * @Author zchengfeng
 * @Date: 2023-11-16 15:42:18
 */
@Data
@Schema(description = "菜单DTO")
public class SysMenuDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8630036546109676305L;

    @Schema(description = "菜单父级id(0表示一级菜单)", defaultValue = "0")
    private Long pId;

    @NotBlank(message = "菜单编码不能为空")
    @Schema(description = "菜单编码")
    private String menuCode;

    @NotBlank(message = "菜单名称不能为空")
    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单类型")
    private int menuType;

    @Schema(description = "菜单路径不能为空")
    private String menuPath;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "菜单图标")
    private String permission_key;

    @Schema(description = "是否外部链接")
    private boolean externalLink;

    @IntOptional(value = {0, 1, 2}, message = "无权限行为输入有误")
    @Schema(description = "无权限行为(0:隐藏,1:禁用,2:消息提示)")
    private int noPermissionAction;

    @Schema(description = "是否可关闭")
    private boolean closable;

    @Schema(description = "是否是新菜单")
    private boolean isNew;
}
