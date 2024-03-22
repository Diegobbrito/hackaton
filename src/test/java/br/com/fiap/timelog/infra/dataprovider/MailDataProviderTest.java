package br.com.fiap.timelog.infra.dataprovider;

import br.com.fiap.timelog.api.exception.MailException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class MailDataProviderTest {

    @InjectMocks
    private MailDataProvider mailDataProvider;
    @Mock
    private JavaMailSender emailSender;

    public MailDataProviderTest() {
    }


    @Test
    void sendEmail() {

        var mock = Mockito.mock(MimeMessage.class);
        when(emailSender.createMimeMessage()).thenReturn(mock);

        doNothing().when(emailSender).send(any(MimeMessage.class));

        assertDoesNotThrow(() ->
                mailDataProvider.sendEmail("test@mail.com", "Text", "Text")
        );
    }

    @Test
    void sendEmailException() {

        var mock = Mockito.mock(MimeMessage.class);
        when(emailSender.createMimeMessage()).thenReturn(mock);

        doThrow(new RuntimeException())
                .when(emailSender).send(any(MimeMessage.class));

        assertThrows(MailException.class, () -> {
            mailDataProvider.sendEmail("test@mail.com", "Text", "Text");
        });
    }
}
