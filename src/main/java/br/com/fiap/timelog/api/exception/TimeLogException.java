package br.com.fiap.timelog.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimeLogException extends RuntimeException {
    public TimeLogException(String mensagem) {
        super(mensagem);
    }
}

