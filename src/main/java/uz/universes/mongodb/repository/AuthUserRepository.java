package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.universes.mongodb.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
}
