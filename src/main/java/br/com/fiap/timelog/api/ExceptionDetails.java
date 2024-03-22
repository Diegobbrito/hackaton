package br.com.fiap.timelog.api;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionDetails {
    private final String error;
    private final LocalDateTime timestamp;

    public ExceptionDetails( String details) {
        this.error = details;
        this.timestamp = LocalDateTime.now();
    }
}
