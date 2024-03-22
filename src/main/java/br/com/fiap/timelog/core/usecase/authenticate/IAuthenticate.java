package br.com.fiap.timelog.core.usecase.authenticate;

import br.com.fiap.timelog.api.dto.request.UserLoginRequest;
import br.com.fiap.timelog.api.dto.response.TokenJWTResponse;

public interface IAuthenticate {
    TokenJWTResponse authenticate(UserLoginRequest request);
}
