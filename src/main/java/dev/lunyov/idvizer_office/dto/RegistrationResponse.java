package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiResponse;
import dev.lunyov.idvizer_office.util.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class RegistrationResponse extends ApiResponse<RegistrationResponse.RegistrationResponseData> {

    public RegistrationResponse(ResponseType responseType, UUID requestId, RegistrationResponseData response) {
        super(responseType, requestId, response);
    }

    @Getter
    @Setter
    public static class RegistrationResponseData {
        private UUID sessionId;
        private String authToken;
        private String refreshToken;

        public RegistrationResponseData(UUID sessionId, String authToken, String refreshToken) {
            this.sessionId = sessionId;
            this.authToken = authToken;
            this.refreshToken = refreshToken;
        }
    }
}