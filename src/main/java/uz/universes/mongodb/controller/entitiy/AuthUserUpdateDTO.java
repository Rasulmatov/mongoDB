package uz.universes.mongodb.controller.entitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserUpdateDTO {
    private Long id;
    private String name;
    private String email;
}
