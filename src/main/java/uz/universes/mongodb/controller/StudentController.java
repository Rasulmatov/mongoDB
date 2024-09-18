package uz.universes.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.dto.CreateStudentDto;
import uz.universes.mongodb.dto.UpdateStudent;
import uz.universes.mongodb.entity.Student;
import uz.universes.mongodb.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<Student>  create(@RequestBody CreateStudentDto dto){
        return ResponseEntity.status(201).body(studentService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getPostId(@PathVariable Integer id) throws InterruptedException {
        return ResponseEntity.ok(studentService.getPostId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPostId(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping()
    public ResponseEntity<Student> deletPostId(@RequestBody UpdateStudent dto) {
       return ResponseEntity.ok(studentService.updatePost(dto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
       return ResponseEntity.ok(studentService.getAll());
    }
}
