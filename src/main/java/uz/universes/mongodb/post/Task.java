package uz.universes.mongodb.post;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Task implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String label;
    private LocalDateTime createdAt;

}
