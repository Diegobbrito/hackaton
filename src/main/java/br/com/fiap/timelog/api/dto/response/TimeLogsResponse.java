package br.com.fiap.timelog.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record TimeLogsResponse(
        List<String> dateTime,
        @Schema(example = "8.0")
        String totalHours) {
}
