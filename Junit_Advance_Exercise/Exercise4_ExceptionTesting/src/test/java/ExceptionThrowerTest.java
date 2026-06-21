import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class ExceptionThrowerTest {
    @Test
    void testExceptionThrown() {
        ExceptionThrower thrower =
                new ExceptionThrower();
        assertThrows(
                RuntimeException.class,
                () -> thrower.throwException()
        );
    }
}