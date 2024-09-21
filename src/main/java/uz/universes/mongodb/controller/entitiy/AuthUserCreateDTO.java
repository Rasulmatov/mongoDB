package uz.universes.mongodb.controller.entitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserCreateDTO {
    private String name;
    private String email;
}
