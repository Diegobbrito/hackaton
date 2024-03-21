package br.com.fiap.pontoeletronico.api.dto.request;

public record AutenticacaoRequest (
        String email,
        String password) {
}
