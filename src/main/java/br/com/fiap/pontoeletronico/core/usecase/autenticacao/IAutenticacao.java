package br.com.fiap.pontoeletronico.core.usecase.autenticacao;

import br.com.fiap.pontoeletronico.api.dto.request.AutenticacaoRequest;
import br.com.fiap.pontoeletronico.api.dto.response.AutenticacaoResponse;

public interface IAutenticacao {
    AutenticacaoResponse autenticar(AutenticacaoRequest request);
}
