package uz.universes.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.entity.UpdatePostDto;
import uz.universes.mongodb.entity.User;
import uz.universes.mongodb.enums.Rating;
import uz.universes.mongodb.repository.PostRepository;
import uz.universes.mongodb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostId(@PathVariable Integer id){
        return postRepository.findById(id).orElse(null);
    }
    @SchemaMapping(typeName = "Query",value = "getPost")
    public Post getPost(@Argument Integer id){
        return postRepository.findById(id).orElse(null);
    }
    @QueryMapping
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
@MutationMapping
    public Post createPost(
            @Argument String title,
            @Argument String body,
            @Argument Integer userId){
        User user = userRepository.findById(userId).get();
        Post newPost = Post.builder()
                .body(body)
                .title(title)
                .user(user)
                .build();
        postRepository.save(newPost);
        return newPost;

    }
    @MutationMapping
    public Post updatePost(
            @Argument UpdatePostDto dto){
        Post updatePost =postRepository.findById(dto.getId()).get();
        if (dto.getTitle() !=null)
            updatePost.setTitle(dto.getTitle());
        if (dto.getBody() != null)
            updatePost.setBody(dto.getBody());
        if (dto.getRating() != null)
            updatePost.setRating(Rating.findByRate(dto.getRating()));
        return postRepository.save(updatePost);
    }


}
