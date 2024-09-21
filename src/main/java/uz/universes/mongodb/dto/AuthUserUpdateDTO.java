package uz.universes.mongodb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserUpdateDTO {
    private Integer id;
    private String name;
    private String email;
}
