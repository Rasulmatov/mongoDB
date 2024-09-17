package uz.universes.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.dto.UpdatePostDTO;
import uz.universes.mongodb.dto.PostCreateDto;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.service.PostService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<Post>  create(@RequestBody PostCreateDto dto){
        return ResponseEntity.status(201).body(postService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostId(@PathVariable Integer id) throws InterruptedException {
        return ResponseEntity.ok(postService.getPostId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPostId(@PathVariable Integer id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping()
    public ResponseEntity<Post> deletPostId(@RequestBody UpdatePostDTO dto) {
       return ResponseEntity.ok(postService.updatePost(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll() {
       return ResponseEntity.ok(postService.getAll());
    }
}
