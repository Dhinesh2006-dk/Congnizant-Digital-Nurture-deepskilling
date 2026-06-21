import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;
public class NotificationManagerTest {
    @Test(expected = RuntimeException.class)
    public void testVoidMethodException() {
        EmailService mockEmailService =
                Mockito.mock(EmailService.class);
        doThrow(new RuntimeException("Email Failed"))
                .when(mockEmailService)
                .sendEmail();
        NotificationManager manager =
                new NotificationManager(mockEmailService);
        try {
            manager.sendNotification();
        } finally {
            verify(mockEmailService)
                    .sendEmail();
        }
    }
}