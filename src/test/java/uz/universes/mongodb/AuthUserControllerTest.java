package uz.universes.mongodb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uz.universes.mongodb.dto.AuthUserCreateDTO;
import uz.universes.mongodb.service.AuthUserService;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthUserController.class)
public class AuthUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthUserService authUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUserTest() throws Exception {
        AuthUserCreateDTO dto = new AuthUserCreateDTO();
        dto.setName("John");

        mockMvc.perform(post("/api/authuser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Successfully Created - User"));

        Mockito.verify(authUserService, Mockito.times(1)).create(any(AuthUserCreateDTO.class));
    }

}
