package uz.universes.mongodb.service.otp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.entity.Users;
import uz.universes.mongodb.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
    private final UserRepository userRepository;

    @Override
    public void generateOtp(Users user) {
        user.setOtp(UUID.randomUUID().toString());
        userRepository.save(user);
    }
}
