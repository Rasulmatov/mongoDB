package uz.universes.mongodb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Student {
    private String id;
    private String name;
    private Integer age;
    private Date birthDate;
    private Gender gender;
    private Group group;
}
