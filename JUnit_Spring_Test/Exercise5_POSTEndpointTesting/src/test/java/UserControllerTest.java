import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Ron");
        when(userService.saveUser(
                org.mockito.ArgumentMatchers.any(User.class)))
                .thenReturn(user);
        String json =
                """
                {
                    "id":1,
                    "name":"Ron"
                }
                """;
        mockMvc.perform(
                post("/users")
                        .contentType(
                                MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}