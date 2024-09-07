package uz.universes.mongodb;

import uz.universes.mongodb.repository.PostRepository;
import uz.universes.mongodb.repository.PostRepositoryImpl;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class PostRespositoryTest {
    public static void main(String[] args) throws Exception {
        PostRepository postRepository=new PostRepositoryImpl();
        Post salomBrinchiBody = postRepository.save(Post.builder()
                .body("salom brinchi body")
                .id(1)
                .userId(12)
                .title("a'lo")
                .build());
        //System.out.println(salomBrinchiBody);

       /* URL url=new URL("https://jsonplaceholder.typicode.com/posts");
        ObjectMapper objectMapper=new ObjectMapper();
        List<Post> posts=objectMapper.readValue(url, new TypeReference<>(){});
        List<Post> savePosts=postRepository.saveAll(posts);
        for (Post post:savePosts){
            System.out.println("savePost: "+post);
        }
*/

        postRepository.getAll(0,20).forEach(System.out::println);






    }
}
