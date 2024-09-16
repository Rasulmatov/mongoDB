package uz.universes.mongodb.service;

import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.dto.UsersDto;
import uz.universes.mongodb.entity.Users;
import uz.universes.mongodb.events.OtpGenerateEvent;
import uz.universes.mongodb.mapper.UserMapper;
import uz.universes.mongodb.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher publisher;
    @Override
    @Transactional
    public Users create(@NonNull UsersDto dto) {
        Users users= userMapper.fromCreateDto(dto);
        userRepository.save(users);
        publisher.publishEvent(new OtpGenerateEvent(users));
        return users;
    }
}
