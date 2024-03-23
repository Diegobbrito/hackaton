package br.com.fiap.timelog.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record TimeLogsRequest(
        @Schema(example = "615243")
        Long userId
){
}
