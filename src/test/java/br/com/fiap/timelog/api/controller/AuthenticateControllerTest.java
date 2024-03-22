package br.com.fiap.timelog.api.controller;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;
import br.com.fiap.timelog.core.usecase.authenticate.IAuthenticate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AuthenticateControllerTest {

    @InjectMocks
    private AuthenticateController controller;
    @Mock
    private IAuthenticate authenticateUseCase;

    public AuthenticateControllerTest() {
    }

    @Test
    void authenticate(){
        UserLoginRequest request = new UserLoginRequest("","");
        when(authenticateUseCase.authenticate(any(UserLoginRequest.class))).thenReturn(new TokenJWTResponse("token"));
        final var response = controller.authenticate(request);
    }
}
