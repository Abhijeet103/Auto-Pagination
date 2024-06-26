package com.autopagination.page.common;

import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.*;

@Aspect
@Component
@NoArgsConstructor
public class PaginationAspect {

    @Autowired
    PaginationCacheService cacheService ;
    private static final String CACHE_NAME = "paginationCache";

    JoinPoint  prev =  null;
    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object paginate(ProceedingJoinPoint joinPoint) throws Throwable {
        // Find the Pageable argument

        Pageable pageable = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof Pageable) {
                pageable = (Pageable) arg;
                break;
            }
        }
        System.out.println(pageable);
        // If there's no Pageable argument, proceed normally
        if (pageable == null) {
            return joinPoint.proceed();
        }


        Object result  = cacheService.retrieveData(joinPoint.getSignature().toString(), () -> {
            try {
                if(!joinPoint.equals(prev))
                {
                    cacheService.clearCache();
                }
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });

        prev =  joinPoint;
        try {

            List<?> list = ((List<?>) result) ;
            System.out.println(list.size());
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), list.size());
            List<?> subList = list.subList(start, end);
            return new PageImpl<>(subList, pageable, list.size()).getContent();
        }
        catch (Exception e)
        {
            return result ;
        }


    }


}


