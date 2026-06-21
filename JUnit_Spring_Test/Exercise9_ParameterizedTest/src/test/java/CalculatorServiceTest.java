import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class CalculatorServiceTest {
    private final CalculatorService service =
            new CalculatorService();
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "10, 20, 30",
            "7, 8, 15"
    })
    public void testAdd(
            int a,
            int b,
            int expected) {
        assertEquals(
                expected,
                service.add(a, b));
    }
}