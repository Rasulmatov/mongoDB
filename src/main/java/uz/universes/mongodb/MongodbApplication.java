package uz.universes.mongodb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.List;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableCaching
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }



}
