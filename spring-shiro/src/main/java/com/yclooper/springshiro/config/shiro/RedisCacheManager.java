package com.yclooper.springshiro.config.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.MapCache;

/**
 * Created by chen on 2020/8/5.
 */
public class RedisCacheManager extends AbstractCacheManager {
    @Override
    protected Cache createCache(String s) throws CacheException {
        return new RedisCache();
    }
}
