package com.fly.common.utils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description 集合工具类,提供集合之间的转换方法
 * @Author zchengfeng
 * @Date 2024/1/17 13:52:58
 */
public class CollectionUtils {

    /**
     * Collection转Map
     *
     * @param collection 转换的集合
     * @param keyMapper  key映射函数
     * @param <T>        Map Value泛型
     * @param <K>        Map Key泛型
     * @return 返回一个Map
     */
    public static <T, K> Map<K, T> toMap(Collection<T> collection, Function<? super T, ? extends K> keyMapper) {
        return HashMap.newHashMap(1);
    }

    /**
     * Collection转Map
     *
     * @param collection  转换的集合
     * @param keyMapper   key映射函数,用于返回Map的key值
     * @param valueMapper value映射函数,用于返回Map的value值
     * @param <T>         集合泛型T
     * @param <K>         Map Key泛型
     * @param <V>         Map Value泛型
     * @return 返回一个Map
     */
    public static <T, K, V> Map<K, V> toMaps(Collection<T> collection, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return HashMap.newHashMap(1);
    }


    /**
     * Collection转Map
     *
     * @param collection    转换的集合
     * @param keyFunction   key映射函数,用于返回Map的key值
     * @param valueFunction value映射函数,用于返回Map的value值
     * @param mergeFunction 一个合并函数，用于解决与同一个键关联的值之间的冲突，如提供给Map.merge（Object、Object、BiFunction）的那样
     * @param <T>           集合泛型T
     * @param <K>           Map Key泛型
     * @param <V>           Map Value泛型
     * @return 返回一个Map
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection, Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        if (collection.isEmpty()) {
            return new HashMap<>(0);
        }
        return collection.stream().collect(Collectors.toMap(keyFunction, valueFunction, mergeFunction));
    }


    /**
     * Collection转List
     *
     * @param collection 转换的集合
     * @param <T>        集合泛型T
     * @return 返回一个List
     */
    public static <T> List<T> toList(Collection<T> collection) {
        if (collection == null) {
            return new ArrayList<>(0);
        }
        if (collection instanceof List) {
            return (List<T>) collection;
        }
        return new ArrayList<>(collection);
    }

    /**
     * Collection转Set
     *
     * @param collection 转换的集合
     * @param <T>        集合泛型T
     * @return 返回一个Set
     */
    public static <T> Set<T> toSet(Collection<T> collection) {
        if (collection == null) {
            return new HashSet<>(0);
        }
        if (collection instanceof Set) {
            return (Set<T>) collection;
        }
        return new HashSet<>(collection);
    }
}
