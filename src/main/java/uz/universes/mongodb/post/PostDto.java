package uz.universes.mongodb.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.universes.mongodb.comment.CommentDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Integer id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
}
