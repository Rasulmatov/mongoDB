package uz.universes.mongodb.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostCreateDto implements Serializable {
    private Integer userID;
    private String title;
    private String body;
}
