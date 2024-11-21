package dev.lunyov.idvizer_office.dto;

import dev.lunyov.idvizer_office.util.ApiResponse;
import dev.lunyov.idvizer_office.util.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RefreshSessionResponse extends ApiResponse<RefreshSessionResponse.RefreshSessionResponseData> {
    public RefreshSessionResponse(ResponseType responseType, UUID requestId, RefreshSessionResponseData response) {
        super(responseType, requestId, response);
    }

    @Getter
    @Setter
    public static class RefreshSessionResponseData {
        private String authToken;
        private String refreshToken;

        public RefreshSessionResponseData(String authToken, String refreshToken) {
            this.authToken = authToken;
            this.refreshToken = refreshToken;
        }
    }
}