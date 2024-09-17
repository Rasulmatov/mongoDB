package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.universes.mongodb.entity.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
