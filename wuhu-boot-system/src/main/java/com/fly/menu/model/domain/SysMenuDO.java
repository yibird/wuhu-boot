package com.fly.menu.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description 系统菜单DO
 * @Author zchengfeng
 * @Date: 2023-07-05 15:42:18
 */
@Data(staticConstructor = "create")
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_menu")
@Schema(name = "菜单DO")
public class SysMenuDO extends BaseDO<SysMenuDO> implements Serializable {
    @Serial
    private static final long serialVersionUID = -5928781825536842705L;

    @Schema(description = "菜单父级id(0表示一级菜单)", defaultValue = "0")
    private Long pId;

    @Schema(description = "菜单编码")
    private String menuCode;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单类型(0:目录,1:菜单,2:按钮)")
    private int menuType;

    @Schema(description = "菜单路径")
    private String menuPath;

    @Schema(description = "菜单图标")
    private String menuIcon;

    @Schema(description = "层级路径(以逗号分隔,父子id),用于优化查找菜单")
    private String levelPath;

    @Schema(description = "权限表示key")
    private String permissionKey;

    @Schema(description = "无权限行为(0:隐藏,1:禁用,2:消息提示)", defaultValue = "0")
    private boolean noPermissionBehavior;

    @Schema(description = "菜单是否可关闭(0:否,1:是)", defaultValue = "0")
    private boolean closable;

    @Schema(description = "是否是新菜单(0:否,1:是)", defaultValue = "0")
    private boolean isNew;

}
