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
import org.springframework.scheduling.annotation.EnableScheduling;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.repository.PostRepository;

import java.net.URL;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableCaching
public class MongodbApplication {
    private final PostRepository postRepository;
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }

    @Bean
    public ApplicationRunner applicationRunner(ObjectMapper objectMapper){
        return (args -> {
            List<Post> posts=objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {
            });
            postRepository.saveAll(posts);
        });
    }

   /* public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(Collections.singleton("posts"));
        return cacheManager;
    }*/


}
