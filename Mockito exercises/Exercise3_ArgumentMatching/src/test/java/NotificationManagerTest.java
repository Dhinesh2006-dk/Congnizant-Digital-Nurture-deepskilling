import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;
public class NotificationManagerTest {
    @Test
    public void testArgumentMatching() {
        MessageService mockService =
                Mockito.mock(MessageService.class);
        NotificationManager manager =
                new NotificationManager(mockService);
        manager.notifyUser();
        verify(mockService)
                .sendMessage(anyString());
    }
}