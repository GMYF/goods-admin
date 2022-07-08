package com.light.springboot.common.cache.local;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class LocalCache {
    private static Cache<String, String> userCache;

    public static synchronized void initCache() {
        userCache =  CacheBuilder.newBuilder()
                // 初始容量
                .initialCapacity(20)
                // 最大容量
                .maximumSize(200)
                //
                .concurrencyLevel(4)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build();
    }
    public static Cache<String, String> getCache() {
        if (userCache == null) {
            initCache();
        }
        return userCache;
    }

}
