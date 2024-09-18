package uz.universes.mongodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.universes.mongodb.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
