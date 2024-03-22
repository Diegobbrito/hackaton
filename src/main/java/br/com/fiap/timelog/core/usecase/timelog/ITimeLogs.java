package br.com.fiap.timelog.core.usecase.timelog;

import br.com.fiap.timelog.api.dto.response.ReportResponse;
import br.com.fiap.timelog.api.dto.request.TimeLogsRequest;
import br.com.fiap.timelog.api.dto.response.TimeLogsResponse;

import java.util.List;

public interface ITimeLogs {

    void createRegistry(TimeLogsRequest request);

    List<TimeLogsResponse> getRegistriesByDate(Long userId, String date);

    ReportResponse generateReport(Long userId, String userEmail);
}
