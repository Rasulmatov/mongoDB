package uz.universes.mongodb;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.entity.User;
import uz.universes.mongodb.enums.Reting;
import uz.universes.mongodb.repository.PostRepository;
import uz.universes.mongodb.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, PostRepository postRepository){
        return args -> {
            User my=new User(1,"Muhammad","Rasulmatov");
            User myUka=new User(2,"Abdulloh","Rasulmatov");
            userRepository.saveAllAndFlush(Arrays.asList(my,myUka));
            var posts= List.of(
                    new Post(1,"Learn GraphQL 1","11111", Reting.FIVE_STARS,my),
                    new Post(2,"Learn GraphQL 22 ","22222" ,Reting.FOUR_STARS,my),
                    new Post(3,"Learn GraphQL 33","33333" ,Reting.THREE_STARS,myUka),
                    new Post(4,"Learn GraphQL 44", "444444",Reting.TWO_STARS,myUka)
            );
            postRepository.saveAll(posts);
        };

    }



}
