package com.autopagination.page.common;



import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class PaginationCacheService {

    private static final String CACHE_NAME = "paginationCache";

    @Cacheable(value = CACHE_NAME, key = "#key")
    public Object retrieveData(String key, Supplier<Object> dataSupplier) {
        return dataSupplier.get();
    }

    @CacheEvict(value = CACHE_NAME, allEntries = true)
    public void clearCache() {
        // This method will be used to clear the cache
    }

    public String generateCacheKey(ProceedingJoinPoint joinPoint) {
        String signature = String.valueOf(joinPoint.getSignature());
        return  signature;
    }
}