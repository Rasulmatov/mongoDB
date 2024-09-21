package uz.universes.mongodb.controller.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthUserGetDTO {
    private Long id;
    private String name;
    private String email;
}
