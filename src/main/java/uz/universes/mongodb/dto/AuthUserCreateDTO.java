package uz.universes.mongodb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserCreateDTO {
    private String name;
    private String email;

}
