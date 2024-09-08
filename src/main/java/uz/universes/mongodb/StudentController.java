package uz.universes.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.universes.mongodb.entity.Gender;
import uz.universes.mongodb.entity.Student;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/gender")
    public List<Student> getStudentsByGender(@RequestParam Gender gender) {
        return studentRepository.findByGender(gender);
    }
    @GetMapping("/page")
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    @GetMapping("/group")
    public List<Student> getStudentsByGroupId(@RequestParam String groupId) {
        return studentRepository.findByGroupId(groupId);
    }
    @GetMapping("/sorted")
    public List<Student> getStudentsSorted(
            @RequestParam String field,
            @RequestParam(defaultValue = "asc") String order) {

        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, field) : Sort.by(Sort.Direction.DESC, field);
        return studentRepository.findAll(sort);
    }
}
