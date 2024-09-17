package uz.universes.mongodb.service;

import lombok.NonNull;
import uz.universes.mongodb.dto.UpdatePostDTO;
import uz.universes.mongodb.dto.PostCreateDto;
import uz.universes.mongodb.entity.Post;

public interface PostService {
    Post create(@NonNull PostCreateDto dto);

    Post getPostId(Integer id) throws InterruptedException;

    void delete(Integer id);

    void updatePost(UpdatePostDTO dto);
}
