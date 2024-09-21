package uz.universes.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.dto.AuthUserCreateDTO;
import uz.universes.mongodb.dto.AuthUserGetDTO;
import uz.universes.mongodb.dto.AuthUserUpdateDTO;
import uz.universes.mongodb.entity.AuthUser;
import uz.universes.mongodb.entity.AuthUserCriteria;
import uz.universes.mongodb.repository.AuthUserRepository;

import java.util.List;

@Service
public class AuthUserService {
    private final AuthUserRepository authUserRepository;

    @Autowired
    public AuthUserService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    public void create(AuthUserCreateDTO dto) {
        AuthUser user = new AuthUser();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        authUserRepository.save(user);
    }

    public void update(AuthUserUpdateDTO dto) {
        AuthUser user = authUserRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        authUserRepository.save(user);
    }

    public void delete(String id) {
        authUserRepository.deleteById(Integer.valueOf(id));
    }

    public AuthUserGetDTO get(String id) {
        AuthUser user = authUserRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new AuthUserGetDTO(user.getId(), user.getName(), user.getEmail());
    }

    public List<AuthUserGetDTO> list(AuthUserCriteria criteria) {
        List<AuthUser> users = authUserRepository.findAll();
        return users.stream()
                .map(user -> new AuthUserGetDTO(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }
}
