package uz.universes.mongodb.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.universes.mongodb.dto.UsersDto;
import uz.universes.mongodb.entity.Users;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    Users fromCreateDto(UsersDto dto);
}
