package br.com.fiap.timelog.api.controller;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;
import br.com.fiap.timelog.core.usecase.authenticate.IAuthenticate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

    private final IAuthenticate authenticateUseCase;

    public AuthenticateController(IAuthenticate authenticateUseCase) {
        this.authenticateUseCase = authenticateUseCase;
    }

    @PostMapping
    public ResponseEntity<TokenJWTResponse> authenticate(@RequestBody UserLoginRequest request){
        final var response = authenticateUseCase.authenticate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
