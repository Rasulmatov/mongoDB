package uz.universes.mongodb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uz.universes.mongodb.entity.AuthUser;
import uz.universes.mongodb.repository.AuthUserRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AuthUserRepositoryTest {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Test
    public void saveUserTest() {
        AuthUser user = new AuthUser();
        user.setName("John");

        AuthUser savedUser = authUserRepository.save(user);
        Optional<AuthUser> foundUser = authUserRepository.findById(savedUser.getId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("John");
    }

    @Test
    public void deleteUserTest() {
        AuthUser user = new AuthUser();
        user.setName("John");

        AuthUser savedUser = authUserRepository.save(user);
        authUserRepository.deleteById(savedUser.getId());

        Optional<AuthUser> foundUser = authUserRepository.findById(savedUser.getId());
        assertThat(foundUser).isNotPresent();
    }
}
