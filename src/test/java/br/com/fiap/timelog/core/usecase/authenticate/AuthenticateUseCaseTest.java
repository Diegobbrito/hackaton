package br.com.fiap.timelog.core.usecase.authenticate;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;
import br.com.fiap.timelog.core.security.JwtTokenService;
import br.com.fiap.timelog.core.security.UserDetailsImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AuthenticateUseCaseTest {

    @InjectMocks
    private AuthenticateUseCase useCase;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenService jwtTokenService;

    public AuthenticateUseCaseTest() {
    }

    @Test
    void authenticate() {

        Authentication authentication = Mockito.mock(Authentication.class);
        when(authenticationManager.authenticate(any())).thenReturn(authentication);

        when(jwtTokenService.generateToken(any())).thenReturn("token");

        var response = useCase.authenticate(new UserLoginRequest("test@email.com", "test"));

        assertEquals("token", response.token());
    }

}
