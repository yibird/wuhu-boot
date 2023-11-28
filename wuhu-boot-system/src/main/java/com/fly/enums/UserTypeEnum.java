package com.fly.enums;

import com.fly.common.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 用户类型枚举类
 * @Author zchengfeng
 * @Date 2023/7/5 16:30
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum implements BaseEnum<Integer,String> {
    ADMIN(0, "管理员"),
    NORMAL_USER(1, "普通用户");
    private final Integer code;
    private final String value;
}
