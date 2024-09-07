package uz.universes.mongodb.repository;

import lombok.NonNull;
import uz.universes.mongodb.Post;

import java.util.List;

public interface PostRepository {
    Post get(String id);
    List<Post> getList();
    List<Post> getAll(int page,int size);
    Post save(@NonNull Post post);
    List<Post> saveAll(@NonNull List<Post> post);
    boolean delete(String id);
    boolean update(Post post);

}
