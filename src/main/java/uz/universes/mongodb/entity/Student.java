package uz.universes.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String groupId;
}
