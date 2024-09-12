package uz.universes.mongodb.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.comment.CommentClient;
import uz.universes.mongodb.comment.CommentCreateDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentClient commentClient;

    @Override
    public PostDto getPost(@NonNull Integer id) {
        Post post= postRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Post"));
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentClient.getAllCommentsByPostId(id))
                .build();
    }

    @Override
    public PostDto createPost(@NonNull PostCreateDto createDto) {
        Post post=Post.builder()
                .title(createDto.getTitle())
                .body(createDto.getBody())
                .build();
        postRepository.save(post);
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    @Override
    public Void createComment(@NonNull List<CommentCreateDTO> commentDto) {
        commentClient.saveAll(commentDto);
       return null;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
}
