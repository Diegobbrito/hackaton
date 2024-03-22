package br.com.fiap.timelog.api;

import br.com.fiap.timelog.api.exception.TimeLogException;
import br.com.fiap.timelog.api.exception.UserException;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handlerUserException(UserException ex){
        final var details = new ExceptionDetails(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handlerTimeLogException(TimeLogException ex){
        final var details = new ExceptionDetails(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handlerException(RuntimeException ex){
        log.error(ex.getMessage());
        final var details = new ExceptionDetails("Erro ao executar");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }
}


