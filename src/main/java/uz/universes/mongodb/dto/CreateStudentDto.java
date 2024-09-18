package uz.universes.mongodb.dto;
import lombok.*;
import uz.universes.mongodb.entity.Address;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentDto {
    private String name;
    private Integer age;
    private String gender;
    private Address address;
    private String email;
    private String phone;
    private List<String> courses;
    private Double gpa;
    private String image;
}
