package com.fly.common.utils;


import com.fly.common.model.vo.TreeNodeAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TreeUtils {
    public static <V, T extends TreeNodeAbstract<T, V>> List<T> toTree(List<T> nodes, Predicate<? super T> predicate) {
        Map<V, List<T>> listMap = nodes.stream().collect(Collectors.groupingBy(TreeNodeAbstract::getParentId));
        return nodes.stream()
                .filter(predicate)
                .map(buildTreeRecursive(listMap))
                .collect(Collectors.toList());
    }

    private static <V, T extends TreeNodeAbstract<T, V>> Function<? super T, T> buildTreeRecursive(Map<V, List<T>> listMap) {
        return node -> {
            List<T> children = listMap.getOrDefault(node.getId(), new ArrayList<>());
            // 如果没有查找到父节点
            if (children.isEmpty()) return node;
            List<T> nodeChildren = children.stream()
                    .map(buildTreeRecursive(listMap))
                    .collect(Collectors.toList());
            node.setChildren(nodeChildren);
            return node;
        };
    }
}
