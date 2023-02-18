package com.fly.model.domain;

import com.fly.common.model.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 系统菜单DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:42:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu extends BaseDO {
    private Long id;
    private Long parentId;
    private String menuName;
    private int menuType;
    private String parentPath;
    private String path;
    private String permissionKey;
    private String icon;
    private int closable;
    private int isNew;
}
