package uz.universes.mongodb.service;

import lombok.NonNull;
import uz.universes.mongodb.dto.UsersDto;
import uz.universes.mongodb.entity.Users;

public interface UsersService {
    Users create(@NonNull UsersDto dto);
}
