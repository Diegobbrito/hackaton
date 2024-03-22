package br.com.fiap.timelog.infra.dataprovider;

import br.com.fiap.timelog.api.exception.MailException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@ExtendWith(SpringExtension.class)
class MailDataProviderTest {

    @InjectMocks
    private MailDataProvider mailDataProvider;
    @Mock
    private JavaMailSender emailSender;

    public MailDataProviderTest() {
    }


    public void sendEmail() {

        doNothing().when(emailSender).send(any(MimeMessage.class));

        mailDataProvider.sendEmail("", "", "");
    }
}
