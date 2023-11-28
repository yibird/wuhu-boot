package com.fly.common.cache;


import java.util.concurrent.Callable;

/**
 * @Description MultipleCache
 * @Author zchengfeng
 * @Date 2023/3/13 14:58
 */
public class MultipleCache implements Cache<String,Object> {

    private MultipleCacheNode cacheNode;

    public MultipleCache(MultipleCacheNode cacheNode) {
        this.cacheNode = cacheNode;
    }

    @Override
    public String getName() {
        return cacheNode.getName();
    }

    @Override
    public Object get(String key) {
        return cacheNode.get(key);
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return (T) cacheNode.get(key, type);
    }

    @Override
    public <T> T get(String key, Callable<T> valueLoader) {
        return (T) cacheNode.get(key, valueLoader);
    }

    @Override
    public void set(String key, Object value) {
        cacheNode.set(key, value);
    }

    @Override
    public boolean has(String key) {
        return cacheNode.has(key);
    }

    @Override
    public void expire(String key) {
        cacheNode.expire(key);
    }


    @Override
    public void clear() {
        cacheNode.clear();
    }

    public static class MultipleCacheBuilder {
        private MultipleCacheNode cache;

        public MultipleCacheBuilder nextNode(Cache cache) {
            MultipleCacheNode node = new MultipleCacheNode(cache);
            if (this.cache == null) {
                this.cache = node;
            } else {
                this.cache.setNextCache(node);
            }
            return this;
        }

        public MultipleCache build() {
            return new MultipleCache(cache);
        }
    }
}
