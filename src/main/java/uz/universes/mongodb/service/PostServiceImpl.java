package uz.universes.mongodb.service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.dto.UpdatePostDTO;
import uz.universes.mongodb.dto.PostCreateDto;
import uz.universes.mongodb.entity.Post;
import uz.universes.mongodb.repository.PostRepository;
import java.util.concurrent.TimeUnit;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CacheManager cacheManager;
    private final Cache cache;

    public PostServiceImpl(PostRepository postRepository, CacheManager cacheManager) {
        this.postRepository = postRepository;
        this.cacheManager = cacheManager;
        this.cache=cacheManager.getCache("post");
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
    public Post getPostId(Integer id){
        Post cachedPost=cache.get(id, Post.class);
        if (cachedPost!=null) {
        return cachedPost;
        }
            Post post = postRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Post Not Found"));
        cache.put(id,post);
            TimeUnit.SECONDS.sleep(5);

            return post;

    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
        cache.evict(id);
    }

    @Override
    public void updatePost(UpdatePostDTO dto) {
        Post post = getPostId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setBody(dto.getBody());
        cache.put(dto.getId(),post);
        postRepository.save(post);
    }
}
