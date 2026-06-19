import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
public class UserServiceTest {
    @Test
    public void testGetUserById() {
        UserRepository mockRepository =
                mock(UserRepository.class);
        User user = new User();
        user.setId(1L);
        user.setName("Ron");
        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(user));
        UserService service =
                new UserService();
        service.setUserRepository(
                mockRepository);
        User result =
                service.getUserById(1L);
        assertEquals("Ron",
                result.getName());
    }
}