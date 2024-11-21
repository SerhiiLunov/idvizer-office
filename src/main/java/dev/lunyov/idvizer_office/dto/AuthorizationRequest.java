package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthorizationRequest extends ApiRequest<AuthorizationRequest.AuthorizationRequestData> {

    public AuthorizationRequest(RequestType requestType, AuthorizationRequestData request) {
        super(requestType, request);
    }

    @Getter
    @Setter
    public static class AuthorizationRequestData {
        @NotNull(message = "authToken cannot be empty")
        private String authToken;

        @NotNull(message = "sessionId cannot be empty")
        private UUID sessionId;

        public AuthorizationRequestData(String authToken, UUID sessionId) {
            this.authToken = authToken;
            this.sessionId = sessionId;
        }
    }
}