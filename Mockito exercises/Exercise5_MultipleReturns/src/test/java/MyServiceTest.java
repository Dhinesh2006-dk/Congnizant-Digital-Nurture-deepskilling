import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
public class MyServiceTest {
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn(
                        "First Call",
                        "Second Call",
                        "Third Call");
        MyService service =
                new MyService(mockApi);
        assertEquals(
                "First Call",
                service.fetchData());
        assertEquals(
                "Second Call",
                service.fetchData());
        assertEquals(
                "Third Call",
                service.fetchData());
    }
}