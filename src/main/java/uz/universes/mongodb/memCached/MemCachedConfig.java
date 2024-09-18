package uz.universes.mongodb.memCached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.universes.mongodb.entity.Student;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCaching
public class MemCachedConfig {
    @Bean
    public MemcachedClient memcachedClient() throws Exception {
        return new XMemcachedClientBuilder("localhost:11211").build();
    }

    @Bean
    public CacheManager cacheManager(MemcachedClient memcachedClient) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Cache cache=new ConcurrentMapCache("student");
        cacheManager.setCaches(Collections.singleton(cache));
        return cacheManager;
    }
}
