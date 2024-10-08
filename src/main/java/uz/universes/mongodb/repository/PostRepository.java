package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.universes.mongodb.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
