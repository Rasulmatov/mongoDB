package uz.universes.mongodb.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersDto {
    private String email;
    private String userName;
    private String password;
}
