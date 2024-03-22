package br.com.fiap.timelog.api.dto.request;

public record UserLoginRequest(
        String email,
        String password) {
}
