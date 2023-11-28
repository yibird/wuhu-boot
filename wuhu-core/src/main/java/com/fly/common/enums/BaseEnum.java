package com.fly.common.enums;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @param <V> 枚举值泛型
 * @Description 基础枚举接口, 提供枚举通用方法
 * @Author zchengfeng
 * @Date 2023/3/14 10:16
 */
public interface BaseEnum<K, V> {
    K getCode();

    V getValue();

    /**
     * 根据枚举code获取对应的枚举值
     *
     * @param enumType 枚举类
     * @param code     枚举code
     * @param <T>      泛型T
     * @return 返回枚举code对应的值
     */
    static <K, V, T extends BaseEnum<K, V>> V valueOf(Class<? extends BaseEnum<K, V>> enumType, Integer code) {
        T[] enumConstants = getEnumConstants(enumType);
        if (code == null || enumConstants == null) return null;
        return Arrays.stream(enumConstants)
                .filter(item -> Objects.equals(item.getCode(), code))
                .findFirst()
                .map(BaseEnum::getValue)
                .orElse(null);
    }

    /**
     * Enum转List
     *
     * @param enumType 枚举类
     * @param <V>      枚举值泛型
     * @param <T>      泛型T
     * @return 返回Enum转List的结果
     */
    static <K, V, T extends BaseEnum<K, V>> List<Map<String, Object>> toList(Class<? extends BaseEnum<K, V>> enumType) {
        T[] enumConstants = getEnumConstants(enumType);
        if (enumConstants == null) return null;
        return Arrays.stream(enumConstants).map(item -> {
            Map<String, Object> map = new HashMap<>();
            map.put("code", item.getCode());
            map.put("value", item.getValue());
            return map;
        }).collect(Collectors.toList());
    }

    /**
     * 获取枚举中所有值集合
     *
     * @param enumType 枚举类
     * @param <V>      枚举值泛型
     * @param <T>      枚举类泛型
     * @return 返回枚举类中所有值集合
     */
    static <K, V, T extends BaseEnum<K, V>> List<V> getValues(Class<? extends BaseEnum<K, V>> enumType) {
        T[] enumConstants = getEnumConstants(enumType);
        if (enumConstants == null) return null;
        return Arrays.stream(enumConstants).map(BaseEnum::getValue)
                .collect(Collectors.toList());
    }

    /**
     * 获取枚举中所有code集合
     *
     * @param enumType 枚举类
     * @param <V>      枚举值泛型
     * @param <T>      枚举类泛型
     * @return 返回枚举类中所有code集合
     */
    static <K, V, T extends BaseEnum<K, V>> List<K> getCodes(Class<? extends BaseEnum<K, V>> enumType) {
        T[] enumConstants = getEnumConstants(enumType);
        if (enumConstants == null) return null;
        return Arrays.stream(enumConstants).map(BaseEnum::getCode)
                .collect(Collectors.toList());
    }

    /**
     * 根据目标枚举类获取其枚举常量集合
     *
     * @param enumType 目标枚举类
     * @param <V>      枚举值泛型
     * @param <T>      枚举类泛型
     * @return 返回对应枚举类的枚举常量集合
     */
    private static <K, V, T extends BaseEnum<K, V>> T[] getEnumConstants(Class<? extends BaseEnum<K, V>> enumType) {
        if (enumType == null) return null;
        @SuppressWarnings("unchecked")
        T[] enumConstants = (T[]) enumType.getEnumConstants();
        return enumConstants;
    }
}
