package uz.universes.mongodb.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.comment.CommentCreateDTO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer id){
        return ResponseEntity.ok(postService.getPost(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity.ok(postService.getAllPost());
    }
    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateDto dto){
        return ResponseEntity.ok(postService.createPost(dto));
    }
    @PostMapping("/comments")
    public ResponseEntity<Void> createComment(@RequestBody List<CommentCreateDTO> commentDto){
        System.out.println("keldi");
        return ResponseEntity.ok(postService.createComment(commentDto));
    }





}
