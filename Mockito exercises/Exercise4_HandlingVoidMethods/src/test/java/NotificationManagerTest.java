import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.mockito.Mockito;
public class NotificationManagerTest {
    @Test
    public void testVoidMethod() {
        EmailService mockEmailService =
                Mockito.mock(EmailService.class);
        doNothing()
                .when(mockEmailService)
                .sendEmail();
        NotificationManager manager =
                new NotificationManager(mockEmailService);
        manager.sendNotification();
        verify(mockEmailService)
                .sendEmail();
    }
}