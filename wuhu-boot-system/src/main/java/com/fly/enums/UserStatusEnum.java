package com.fly.enums;

import com.fly.common.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 用户状态枚举类
 * @Author zchengfeng
 * @Date 2023/7/5 16:30
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum implements BaseEnum<Integer,String> {
    ENABLED(0, "启用"),
    DISABLE(1, "禁用");

    private final Integer code;
    private final String value;
}

