package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.universes.mongodb.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
