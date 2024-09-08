package uz.universes.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("posts")
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Post {
    @Id
    private String postId;
    private String title;
    private String body;
    private Integer userId;
    private Integer id;
}


