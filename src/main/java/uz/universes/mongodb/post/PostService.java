package uz.universes.mongodb.post;

import lombok.NonNull;
import uz.universes.mongodb.comment.CommentCreateDTO;

import java.util.List;

public interface PostService {
    PostDto getPost(@NonNull Integer id);
    PostDto createPost(@NonNull PostCreateDto createDto);
    Void createComment(@NonNull List<CommentCreateDTO> commentDto);
    List<Post> getAllPost();
}
