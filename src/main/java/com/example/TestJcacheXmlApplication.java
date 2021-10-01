package com.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration(proxyBeanMethods = false)
@ComponentScan
@ImportResource("classpath:test.xml")
public class TestJcacheXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJcacheXmlApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public ApplicationRunner applicationRunner(CacheService cacheService) {
        return args -> {
            System.out.println(cacheService.get("test"));
            System.out.println(cacheService.get("test"));
        };
    }

}
