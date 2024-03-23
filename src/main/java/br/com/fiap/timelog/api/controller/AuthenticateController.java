package br.com.fiap.timelog.api.controller;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;
import br.com.fiap.timelog.core.usecase.authenticate.IAuthenticate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@Tag(name = "Authenticate", description = "Authentication of users returning a token JWT")
public class AuthenticateController {

    private final IAuthenticate authenticateUseCase;

    public AuthenticateController(IAuthenticate authenticateUseCase) {
        this.authenticateUseCase = authenticateUseCase;
    }

    @PostMapping
    @Operation(summary = "Authentication of users by email and password")
    public ResponseEntity<TokenJWTResponse> authenticate(@RequestBody UserLoginRequest request){
        final var response = authenticateUseCase.authenticate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
