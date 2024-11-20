package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.universes.mongodb.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select p from Post p where p.user.id= ?1")
    List<Post> findBy_Id(Integer id);
}
