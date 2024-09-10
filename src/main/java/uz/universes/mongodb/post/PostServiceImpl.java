package uz.universes.mongodb.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.universes.mongodb.comment.CommentCreateDTO;
import uz.universes.mongodb.comment.CommentResource;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentResource commentResource;

    @Override
    @SuppressWarnings("rawtypes")
    public PostDto getPost(@NonNull Integer id) {
        Post post= postRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found Post"));

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentResource.getAllComments(id))
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
        commentResource.saveAll(commentDto);
       return null;
    }
}
