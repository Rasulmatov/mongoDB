package uz.universes.mongodb.memCached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MemCachedConfig {
    @Bean
    public MemcachedClient memcachedClient() throws Exception {
        return new XMemcachedClientBuilder("localhost:11211").build();
    }

  /*  @Bean
    public CacheManager cacheManager(MemcachedClient memcachedClient) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Cache cache=new ConcurrentMapCache("student");
        cacheManager.setCaches(Collections.singleton(cache));
        return cacheManager;
    }*/
    //ruchnoy qolda ishlash uchun
}
