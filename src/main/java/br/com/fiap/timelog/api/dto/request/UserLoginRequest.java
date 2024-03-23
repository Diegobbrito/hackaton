package br.com.fiap.timelog.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserLoginRequest(
        @Schema(example = "diego@postech.com")
        String email,
        @Schema(example = "secret")
        String password) {
}
