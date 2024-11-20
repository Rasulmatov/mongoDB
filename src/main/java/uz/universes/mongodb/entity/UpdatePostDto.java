package uz.universes.mongodb.entity;

import lombok.*;
import uz.universes.mongodb.enums.Rating;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpdatePostDto {
    private Integer id;
    private String title;
    private String body;
    private String rating;
}
