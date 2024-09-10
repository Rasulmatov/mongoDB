package uz.universes.mongodb.comment;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import uz.universes.mongodb.post.PostDto;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {
    private final WebClient webClient;
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    public List<CommentDTO> getAllComments(@NonNull Integer id){
        return webClient.get()
                .uri(postCommentsURL,id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDTO>>() {})
                .block();
    }
    public void saveAll(List<CommentCreateDTO> commentCreateDTOS){
        webClient.post()
                .uri(saveCommentsURL)
                .body(BodyInserters.fromValue(commentCreateDTOS))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
