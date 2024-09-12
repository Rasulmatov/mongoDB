package uz.universes.mongodb.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping()
    public ResponseEntity<List<Task>> getAllTask(){
        log.info("Request All Task");
        return ResponseEntity.ok(taskRepository.getAll());
    }

}
