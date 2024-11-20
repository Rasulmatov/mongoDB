package uz.universes.mongodb.controller;

import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.universes.mongodb.entity.User;
import uz.universes.mongodb.entity.UserDto;
import uz.universes.mongodb.entity.UserUpdateDto;
import uz.universes.mongodb.repository.PostRepository;
import uz.universes.mongodb.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<User> user= userRepository.findAll();
        return user.stream().map(user1 -> {
          var dto=  new UserDto(user1.getId(),user1.getFirst_name(),user1.getLast_name());
          dto.setPosts(postRepository.findBy_Id(user1.getId()));
          return dto;
        }).toList();
    }

    @PutMapping
    public User updateUser(@RequestBody UserUpdateDto dto){
        User user=userRepository.findById(dto.getId()).orElseThrow(()-> new RuntimeException("User Not Found"));
        if (Objects.nonNull(dto.getFirst_name())){
            user.setFirst_name(dto.getFirst_name());
        }
        if (Objects.nonNull(dto.getLast_name())){
            user.setLast_name(dto.getLast_name());
        }
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

}
