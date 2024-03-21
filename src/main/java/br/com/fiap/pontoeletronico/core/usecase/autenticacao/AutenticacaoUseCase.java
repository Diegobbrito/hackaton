package br.com.fiap.pontoeletronico.core.usecase.autenticacao;

import br.com.fiap.pontoeletronico.api.dto.request.AutenticacaoRequest;
import br.com.fiap.pontoeletronico.api.dto.response.AutenticacaoResponse;
import br.com.fiap.pontoeletronico.core.security.JwtTokenService;
import br.com.fiap.pontoeletronico.core.security.UsuarioDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

@Service
public class AutenticacaoUseCase implements IAutenticacao {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public AutenticacaoResponse autenticar(AutenticacaoRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UsuarioDetails userDetails = (UsuarioDetails) authentication.getPrincipal();
        return new AutenticacaoResponse(jwtTokenService.generateToken(userDetails));
    }

}
