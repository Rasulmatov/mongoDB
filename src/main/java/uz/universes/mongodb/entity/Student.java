package uz.universes.mongodb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    @Embedded
    private Address address;
    private String email;
    private String phone;
    @ElementCollection
    private List<String> courses;
    private Double gpa;
    private String image;
}
