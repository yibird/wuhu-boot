package com.fly.common.utils;

import com.fly.common.model.query.BaseQuery;
import com.mybatisflex.core.paginate.Page;

/**
 * @Description PageUtil
 * @Author zchengfeng
 * @Date 2023/3/17 16:15
 */
public class PageUtil {
    public static <T, Q extends BaseQuery> Page<T> toPage(Q query) {
        return Page.of(query.getCurrent(), query.getPageSize());
    }
}
