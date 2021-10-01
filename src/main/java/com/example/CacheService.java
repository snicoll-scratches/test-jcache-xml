package com.example;

import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheResult;
import java.time.Instant;

@Component
public class CacheService {

    @CacheResult(cacheName = "test")
    public String get(String id) {
        return id + Instant.now().toString();
    }

}
