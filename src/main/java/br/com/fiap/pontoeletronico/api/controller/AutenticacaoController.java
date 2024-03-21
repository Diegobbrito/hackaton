package br.com.fiap.pontoeletronico.api.controller;

import br.com.fiap.pontoeletronico.api.dto.request.AutenticacaoRequest;
import br.com.fiap.pontoeletronico.api.dto.response.AutenticacaoResponse;
import br.com.fiap.pontoeletronico.core.usecase.autenticacao.IAutenticacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/authenticate")
public class AutenticacaoController {

    private final IAutenticacao autenticacaoUseCase;

    public AutenticacaoController(IAutenticacao autenticacaoUseCase) {
        this.autenticacaoUseCase = autenticacaoUseCase;
    }

    @PostMapping
    public ResponseEntity<AutenticacaoResponse> autenticar(@RequestBody AutenticacaoRequest request){
        final var response = autenticacaoUseCase.autenticar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
