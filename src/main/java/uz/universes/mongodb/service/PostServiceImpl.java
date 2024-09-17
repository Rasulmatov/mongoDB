package uz.universes.mongodb.service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.dto.UpdatePostDTO;
import uz.universes.mongodb.dto.PostCreateDto;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.repository.PostRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public Post create(@NonNull PostCreateDto dto) {
        Post post=Post.builder()
                .userId(dto.getUserID())
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
          postRepository.save(post);
          return post;
    }

    @Override
    @SneakyThrows
    @Cacheable(value = "posts",key = "#id")
    public Post getPostId(Integer id){
            Post post = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Post Not Found"));
            TimeUnit.SECONDS.sleep(5);

            return post;

    }

    @Override
    @CacheEvict(value = "posts",key = "#id")
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    @CachePut(value = "posts",key = "#dto.id")
    public Post updatePost(UpdatePostDTO dto) {
        Post post = getPostId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        postRepository.save(post);
        return post;
    }

    @Override
    @Cacheable(value = "posts",key = "#root.methodName")
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
