package br.com.fiap.timelog.api.controller;

import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.api.dto.response.ReportResponse;
import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;
import br.com.fiap.timelog.api.exception.UserException;
import br.com.fiap.timelog.core.security.JwtTokenService;
import br.com.fiap.timelog.core.usecase.timelog.ITimeLogs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TimeLogsControllerTest {

    @InjectMocks
    private TimeLogsController controller;
    @Mock
    private ITimeLogs timeClockUseCase;
    @Mock
    private JwtTokenService jwtTokenService;

    public TimeLogsControllerTest() {
    }
    @Test
    void createRegistry(){
        TimeLogsRequest request = new TimeLogsRequest(1L);
        when(jwtTokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        doNothing().when(timeClockUseCase).createRegistry(any());

        var response = controller.createRegistry(request,"Bearer token");
        assertNotNull(response);
    }
    @Test
    void getRegistriesByDate() {
        when(jwtTokenService.getUserIdFromToken(anyString())).thenReturn(1L);

        List<TimeLogsResponse> list = List.of(new TimeLogsResponse(List.of("day 1 12:00"), "8.0"));

        when(timeClockUseCase.getRegistriesByDate(anyLong(), anyString())).thenReturn(list);
        var response = controller.getRegistriesByDate("23-03-2024", "Bearer token");
        assertNotNull(response);
        assertEquals(1 , response.getBody().get(0).dateTime().size());
        assertEquals("8.0", response.getBody().get(0).totalHours());
        assertEquals("day 1 12:00", response.getBody().get(0).dateTime().get(0));
    }
    @Test
    void generateReport() {
        when(jwtTokenService.getUserIdFromToken(anyString())).thenReturn(1L);
        when(jwtTokenService.getSubjectFromToken(anyString())).thenReturn("test@mail.com");
        ReportResponse report = new ReportResponse("OK");
        when(timeClockUseCase.generateReport(anyLong(), anyString())).thenReturn(report);

        var response = controller.generateReport("Bearer token");
        assertEquals("OK", Objects.requireNonNull(response.getBody()).result());

    }

}
