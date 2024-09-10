package uz.universes.mongodb.comment;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uz.universes.mongodb.post.PostDto;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {
    private final RestTemplate restTemplate;
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    public List<CommentDTO> getAllComments(@NonNull Integer id){
        try {
            List comments= restTemplate.getForObject(postCommentsURL, List.class, id);
            return comments;
        }catch (ResourceAccessException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public void saveAll(List<CommentCreateDTO> commentCreateDTOS){
        restTemplate.postForObject(saveCommentsURL,commentCreateDTOS,Void.class);
    }

}
