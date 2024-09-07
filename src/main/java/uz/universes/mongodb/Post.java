package uz.universes.mongodb;

import lombok.*;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"title","body"})
@Builder
public class Post {
    private Object objectId;
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

    public Post(Document document) {
        this.objectId = document.getObjectId("_id");
        this.id = document.getInteger("id");
        this.userId = document.getInteger("userId");
        this.title = document.getString("title");
        this.body = document.getString("body");
    }
}
