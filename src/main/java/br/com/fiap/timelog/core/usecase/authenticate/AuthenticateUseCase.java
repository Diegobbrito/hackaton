package br.com.fiap.timelog.core.usecase.authenticate;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;
import br.com.fiap.timelog.core.security.JwtTokenService;
import br.com.fiap.timelog.core.security.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

@Service
public class AuthenticateUseCase implements IAuthenticate {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenService jwtTokenService;

    public AuthenticateUseCase(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public TokenJWTResponse authenticate(UserLoginRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return new TokenJWTResponse(jwtTokenService.generateToken(userDetails));
    }

}
