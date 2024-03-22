package br.com.fiap.timelog.api.dto.response;

import java.util.List;

public record TimeLogsResponse(List<String> dateTime, String totalHours) {
}
