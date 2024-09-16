package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.universes.mongodb.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
