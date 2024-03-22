package br.com.fiap.timelog.core.usecase.email;

import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;
import br.com.fiap.timelog.api.exception.UserException;
import br.com.fiap.timelog.core.entity.User;
import br.com.fiap.timelog.infra.dataprovider.MailDataProvider;
import br.com.fiap.timelog.infra.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MailUseCaseTest {

    @InjectMocks
    private MailUseCase useCase;
    @Mock
    private UserRepository repository;
    @Mock
    private MailDataProvider mailDataProvider;

    public MailUseCaseTest() {
    }


    @Test
    void sendMail() {
        var user = new User(1L, "Test","test@mail.com", "", "USER");
        when(repository.findByEmail(anyString()))
                .thenReturn(Optional.of(user));

        doNothing().when(mailDataProvider).sendEmail(anyString(), anyString(), anyString());

        var timelog = new TimeLogsResponse(List.of("day 1 8:00"), "8.0");

        assertDoesNotThrow(() ->
                useCase.sendMail("email@mail.com", List.of(timelog), LocalDate.now())
        );
    }

    @Test
    void sendMailUserException() {
        when(repository.findByEmail(anyString()))
                .thenReturn(Optional.empty());

        doNothing().when(mailDataProvider).sendEmail(anyString(), anyString(), anyString());

        var timelog = new TimeLogsResponse(List.of("day 1 8:00"), "8.0");

        assertThrows(UserException.class, () ->
                useCase.sendMail("email@mail.com", List.of(timelog), LocalDate.now())
        );
    }
}
