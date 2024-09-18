package uz.universes.mongodb.service;

import lombok.NonNull;
import uz.universes.mongodb.dto.CreateStudentDto;
import uz.universes.mongodb.dto.UpdateStudent;
import uz.universes.mongodb.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(@NonNull CreateStudentDto dto);

    Student getPostId(Integer id) throws InterruptedException;

    void delete(Integer id);

    Student updatePost(UpdateStudent dto);

    List<Student> getAll();
}
