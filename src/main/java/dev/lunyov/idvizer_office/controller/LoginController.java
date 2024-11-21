package dev.lunyov.idvizer_office.controller;

import dev.lunyov.idvizer_office.dto.LoginLinkRequest;
import dev.lunyov.idvizer_office.dto.LoginRequest;
import dev.lunyov.idvizer_office.dto.RegistrationResponse;
import dev.lunyov.idvizer_office.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/send-login-link")
    public ResponseEntity<String> sendLoginLink(@RequestBody LoginLinkRequest request) {
        String email = request.getRequest().getEmail();
        loginService.sendLoginLink(email);
        return ResponseEntity.ok("Login link sent to your email.");
    }

    @PostMapping("/complete-login")
    public ResponseEntity<RegistrationResponse> completeLogin(@RequestBody LoginRequest loginRequest) {
        RegistrationResponse response = loginService.completeLogin(
                loginRequest.getRequest().getJwtVersion(),
                loginRequest.getRequest().getBase64Jwt()
        );
        return ResponseEntity.ok(response);
    }
}