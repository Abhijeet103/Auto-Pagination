package com.autopagination.page;


import com.autopagination.page.common.PaginationAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ConditionalOnWebApplication
@EnableAspectJAutoProxy
@EnableCaching
public class PaginationAutoConfiguration {

    @Bean
    public PaginationAspect paginationAspect() {
        return new PaginationAspect();
    }
}