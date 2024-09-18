package uz.universes.mongodb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.dto.CreateStudentDto;
import uz.universes.mongodb.dto.UpdateStudent;
import uz.universes.mongodb.entity.Student;
import uz.universes.mongodb.repository.StudentRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final ObjectMapper objectMapper;

    public StudentServiceImpl(StudentRepository postRepository, ObjectMapper objectMapper) {
        this.studentRepository = postRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public Student create(@NonNull CreateStudentDto dto) {
      Student student=objectMapper.convertValue(dto,Student.class);
        System.out.println(student);
          studentRepository.save(student);
          return student;
    }

    @Override
    @SneakyThrows
    @Cacheable(value = "student",key = "#id")
    public Student getPostId(Integer id){
            Student post = studentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Post Not Found"));
            TimeUnit.SECONDS.sleep(5);
            return post;
    }

    @Override
    @CacheEvict(value = "student",key = "#id")
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    @CachePut(value = "student",key = "#dto.id")
    public Student updatePost(UpdateStudent dto) {
        Student post =objectMapper.convertValue(dto,Student.class);
        studentRepository.save(post);
        return post;
    }

    @Override
    @Cacheable(value = "student",key = "#root.methodName")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
