package uz.universes.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.universes.mongodb.entity.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudent {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Address address;
    private String email;
    private String phone;
}
