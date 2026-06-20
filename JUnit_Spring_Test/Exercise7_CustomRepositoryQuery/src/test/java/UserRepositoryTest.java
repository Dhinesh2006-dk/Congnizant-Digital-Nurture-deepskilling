import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Test
    public void testFindByName() {
        User user = new User();
        user.setId(1L);
        user.setName("Ron");
        repository.save(user);
        List<User> users =
                repository.findByName("Ron");
        assertEquals(1, users.size());
        assertEquals("Ron",
                users.get(0).getName());
    }
}