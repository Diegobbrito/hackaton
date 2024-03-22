package br.com.fiap.timelog.core.usecase.email;

import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;

import java.time.LocalDate;
import java.util.List;

public interface IMail {

    void sendMail(String userEmail, List<TimeLogsResponse> report, LocalDate date);
}
