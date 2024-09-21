package uz.universes.mongodb;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.dto.AuthUserCreateDTO;
import uz.universes.mongodb.dto.AuthUserGetDTO;
import uz.universes.mongodb.dto.AuthUserUpdateDTO;
import uz.universes.mongodb.entity.AuthUserCriteria;
import uz.universes.mongodb.service.AuthUserService;

import java.util.List;

@RestController
@RequestMapping("/api/authuser")
@Validated
public class AuthUserController {
    private final AuthUserService service;

    public AuthUserController(AuthUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody AuthUserCreateDTO dto) {
        service.create(dto);
        return new ResponseEntity<>("Successfully Created - User", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@Valid @RequestBody AuthUserUpdateDTO dto) {
        service.update(dto);
        return new ResponseEntity<>("Successfully Updated - User", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>("Successfully Deleted - User", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthUserGetDTO> get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthUserGetDTO>> list(@Valid AuthUserCriteria criteria) {
        return new ResponseEntity<>(service.list(criteria), HttpStatus.OK);
    }
}
