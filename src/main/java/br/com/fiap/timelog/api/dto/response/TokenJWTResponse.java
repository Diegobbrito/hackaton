package br.com.fiap.timelog.api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record TokenJWTResponse(
        @Schema(example = "token")
        String token
) {
}
