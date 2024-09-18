package uz.universes.mongodb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import uz.universes.mongodb.entity.Student;
import uz.universes.mongodb.repository.StudentRepository;

import java.net.URL;
import java.util.List;


@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableCaching
@EnableScheduling
public class MongodbApplication {
    private final StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }

    @Bean
    public ApplicationRunner applicationRunners(ObjectMapper objectMapper){
        return (args -> {
            List<Student> posts=objectMapper.readValue(new URL("https://freetestapi.com/api/v1/students"), new TypeReference<>() {
            });
            studentRepository.saveAll(posts);
        });
    }


}
