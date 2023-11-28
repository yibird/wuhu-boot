package com.fly.common.config.cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;
import net.oschina.j2cache.J2CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;
import java.util.Collections;

public class J2CacheSpringCacheManageAdapter extends AbstractTransactionSupportingCacheManager {

    private J2CacheBuilder j2CacheBuilder;
    private boolean allowNullValues = true;
    public J2CacheSpringCacheManageAdapter(J2CacheBuilder j2CacheBuilder, boolean allowNullValues) {
        this.j2CacheBuilder = j2CacheBuilder;
        this.allowNullValues = allowNullValues;
    }

    public J2CacheSpringCacheManageAdapter() {
    }

    public J2CacheSpringCacheManageAdapter(boolean allowNullValues) {
        this.allowNullValues = allowNullValues;
    }

    public J2CacheSpringCacheManageAdapter(J2CacheBuilder j2CacheBuilder) {
        this.j2CacheBuilder = j2CacheBuilder;
    }

    @Override
    protected Cache getMissingCache(String name) {
        CacheChannel cacheChannel = j2CacheBuilder == null ? J2Cache.getChannel() : j2CacheBuilder.getChannel();
        return new J2CacheSpringCacheAdapter(allowNullValues, cacheChannel, name);
    }
    @Override
    protected Collection<? extends Cache> loadCaches() {
        return Collections.emptyList();
    }
}
