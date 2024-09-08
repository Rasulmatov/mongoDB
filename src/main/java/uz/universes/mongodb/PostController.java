package uz.universes.mongodb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable String id){
        Post post=postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));
        return ResponseEntity.ok(post);
    }
    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(postRepository.save(post));
    }
    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post updatePost){
        Post post=postRepository.findById(updatePost.getPostId())
                .orElseThrow(() -> new RuntimeException("Post Not Found"));
        if (post.getTitle()!=null){
            post.setTitle(updatePost.getTitle());
        }
        if (post.getBody()!=null){
            post.setBody(updatePost.getBody());
        }
        if (post.getUserId()!=null){
            post.setUserId(updatePost.getUserId());
        }
        if (post.getId()!=null){
            post.setId(updatePost.getId());
        }
        postRepository.save(post);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
