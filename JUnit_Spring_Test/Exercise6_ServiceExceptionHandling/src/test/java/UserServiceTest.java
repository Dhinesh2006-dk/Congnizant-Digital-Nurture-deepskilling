import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;
public class UserServiceTest {
    @Test
    public void testUserNotFound() {
        UserRepository mockRepository =
                mock(UserRepository.class);
        when(mockRepository.findById(1L))
                .thenReturn(Optional.empty());
        UserService service =
                new UserService(mockRepository);
        assertThrows(RuntimeException.class,
                () -> service.getUserById(1L));
    }
}