package uz.universes.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }
}
