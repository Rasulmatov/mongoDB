package uz.universes.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthUserGetDTO {
    private Integer id;
    private String name;
    private String email;
}
