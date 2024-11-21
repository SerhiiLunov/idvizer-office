package dev.lunyov.idvizer_office.service;

import dev.lunyov.idvizer_office.dto.RefreshSessionResponse;
import dev.lunyov.idvizer_office.dto.SimpleResponse;
import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.util.ApiResponse;
import dev.lunyov.idvizer_office.util.ResponseType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final SessionService sessionService;

    public AuthService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public ApiResponse<Void> authorize(UUID sessionId, String authToken) {
        boolean isValid = sessionService.validateAuthToken(sessionId, authToken);

        if (isValid) {
            return new SimpleResponse<>(ResponseType.SUCCESS, UUID.randomUUID());
        } else {
            return new SimpleResponse<>(ResponseType.AUTHORIZATION_ERROR, UUID.randomUUID());
        }
    }

    public ApiResponse<RefreshSessionResponse.RefreshSessionResponseData> refreshSession(
            UUID sessionId, String refreshToken) {
        try {
            Session session = sessionService.refreshSession(sessionId, refreshToken);

            return new RefreshSessionResponse(
                    ResponseType.SUCCESS,
                    UUID.randomUUID(),
                    new RefreshSessionResponse.RefreshSessionResponseData(
                            session.getAuthToken(),
                            session.getRefreshToken()
                    )
            );
        } catch (IllegalArgumentException e) {
            return new SimpleResponse<>(ResponseType.ERROR, UUID.randomUUID());
        }
    }
}

