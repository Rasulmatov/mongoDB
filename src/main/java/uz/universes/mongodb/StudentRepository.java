package uz.universes.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uz.universes.mongodb.entity.Gender;
import uz.universes.mongodb.entity.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {
    @Query("{ 'gender': ?0 }")
    List<Student> findByGender(Gender gender);
    Page<Student> findAll(Pageable pageable);
    @Query("{ 'groupId': ?0 }")
    List<Student> findByGroupId(String groupId);
    List<Student> findAll(Sort sort);
}
