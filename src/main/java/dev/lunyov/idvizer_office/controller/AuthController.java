package dev.lunyov.idvizer_office.controller;

import dev.lunyov.idvizer_office.dto.AuthorizationRequest;
import dev.lunyov.idvizer_office.dto.RefreshSessionRequest;
import dev.lunyov.idvizer_office.dto.RefreshSessionResponse;
import dev.lunyov.idvizer_office.service.AuthService;
import dev.lunyov.idvizer_office.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authorize")
    public ResponseEntity<ApiResponse<Void>> authorize(@RequestBody AuthorizationRequest request) {
        UUID sessionId = request.getRequest().getSessionId();
        String authToken = request.getRequest().getAuthToken();

        ApiResponse<Void> response = authService.authorize(sessionId, authToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-session")
    public ResponseEntity<ApiResponse<RefreshSessionResponse.
            RefreshSessionResponseData>> refreshSession(@RequestBody RefreshSessionRequest request) {
        UUID sessionId = request.getRequest().getSessionId();
        String refreshToken = request.getRequest().getRefreshToken();

        ApiResponse<RefreshSessionResponse.RefreshSessionResponseData> response = authService.
                refreshSession(sessionId, refreshToken);
        return ResponseEntity.ok(response);
    }
}