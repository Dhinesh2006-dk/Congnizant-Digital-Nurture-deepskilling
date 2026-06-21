import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class CalculatorServiceTest {
    @Test
    public void testAdd() {
        CalculatorService calculatorService =
                new CalculatorService();
        int result =
                calculatorService.add(10, 20);
        assertEquals(30, result);
    }
}