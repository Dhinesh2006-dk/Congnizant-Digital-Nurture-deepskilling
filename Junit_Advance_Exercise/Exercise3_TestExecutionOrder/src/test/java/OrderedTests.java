import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    @Test
    @Order(1)
    void testFirst() {
        System.out.println("First Test");
    }
    @Test
    @Order(2)
    void testSecond() {
        System.out.println("Second Test");
    }
    @Test
    @Order(3)
    void testThird() {
        System.out.println("Third Test");
    }
}