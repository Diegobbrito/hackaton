package br.com.fiap.timelog.infra.dataprovider;

import br.com.fiap.timelog.api.exception.MailException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailDataProvider {
    private final JavaMailSender emailSender;

    public MailDataProvider(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendEmail(String to, String title, String messageText) {

        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress("pos-tech@fiap.com.br"));
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setSubject(title);
            message.setContent(messageText, "text/html; charset=utf-8");
            emailSender.send(message);
        }catch (Exception e){
            throw new MailException("Erro ao enviar o email");
        }
    }
}
