package br.com.fiap.timelog.core.usecase.timelog;

import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.core.entity.TimeLogs;
import br.com.fiap.timelog.core.entity.User;
import br.com.fiap.timelog.core.usecase.email.IMail;
import br.com.fiap.timelog.infra.repository.TimeLogsRepository;
import br.com.fiap.timelog.infra.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TimeLogsUseCaseTest {

    @InjectMocks
    private TimeLogsUseCase useCase;
    @Mock
    private TimeLogsRepository repository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private IMail sendMail;

    public TimeLogsUseCaseTest() {
    }

    @Test
    void createRegistry() {
        var user = new User(1L, "Test","test@mail.com", "", "USER");

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        TimeLogs timeLogs = TimeLogs.builder().id(1L).userId(1L).timeStampRegistry(Timestamp.from(Instant.now().minusSeconds(100))).build();
        when(repository
                .findLastLogByUserId(anyLong())).thenReturn(Optional.of(timeLogs));

        useCase.createRegistry(new TimeLogsRequest(1L));

    }

    @Test
    void getRegistriesByDate() {
        TimeLogs timeLogs = TimeLogs.builder().id(1L).userId(1L).timeStampRegistry(Timestamp.from(Instant.now())).build();
        when(repository.findAllByUserIdAndDate(anyLong(), any())).thenReturn(List.of(timeLogs));
        var response = useCase.getRegistriesByDate(1L, "01-03-2024");
    }

    @Test
    void generateReport() {
        TimeLogs timeLogs = TimeLogs.builder().id(1L).userId(1L).timeStampRegistry(Timestamp.from(Instant.now())).build();

         when(repository.findAllByUserIdAndLastMonth(anyLong(), any())).thenReturn(List.of(timeLogs));


        doNothing().when(sendMail).sendMail(anyString(), anyList(), any());

        var response = useCase.generateReport(1L, "01-03-2024");

    }


}
