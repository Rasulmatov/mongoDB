package uz.universes.mongodb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import uz.universes.mongodb.dto.AuthUserCreateDTO;
import uz.universes.mongodb.dto.AuthUserGetDTO;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthUserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUserTest() throws Exception {
        AuthUserCreateDTO dto = new AuthUserCreateDTO();
        dto.setName("John");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(dto), headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/authuser", HttpMethod.POST, request, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).isEqualTo("Successfully Created - User");
    }

    @Test
    public void getUserTest() throws Exception {
        ResponseEntity<AuthUserGetDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/authuser/1", AuthUserGetDTO.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getName()).isEqualTo("John");
    }
}
