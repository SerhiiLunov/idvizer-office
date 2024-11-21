package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiRequest;
import dev.lunyov.idvizer_office.util.RequestType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RefreshSessionRequest extends ApiRequest<RefreshSessionRequest.RefreshSessionRequestData> {

    public RefreshSessionRequest(RequestType requestType, RefreshSessionRequestData request) {
        super(requestType, request);
    }

    @Getter
    @Setter
    public static class RefreshSessionRequestData {
        @NotNull(message = "sessionId cannot be empty")
        private UUID sessionId;

        @NotNull(message = "refreshToken cannot be empty")
        private String refreshToken;

        public RefreshSessionRequestData(UUID sessionId, String refreshToken) {
            this.sessionId = sessionId;
            this.refreshToken = refreshToken;
        }
    }
}