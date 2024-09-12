package uz.universes.mongodb.comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value ="CommentClient",url = "${comments.url.base}")
public interface CommentClient {

    @GetMapping("/{id}/post")
    List<CommentDTO> getAllCommentsByPostId(@PathVariable Integer id);
    @PostMapping("/saveAll")
    Void saveAll(@RequestBody List<CommentCreateDTO> commentCreateDTOS);
}
