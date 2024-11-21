package dev.lunyov.idvizer_office.controller;

import dev.lunyov.idvizer_office.dto.CompleteRegistrationRequest;
import dev.lunyov.idvizer_office.dto.InitiateRegistrationRequest;
import dev.lunyov.idvizer_office.dto.RegistrationResponse;
import dev.lunyov.idvizer_office.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody InitiateRegistrationRequest registrationRequest) {
        String email = registrationRequest.getRequest().getEmail();
        String phone = registrationRequest.getRequest().getPhone();

        registrationService.initiateRegistration(email, phone);

        return ResponseEntity.ok("Registration link sent to your email.");
    }

    @PostMapping("/complete-registration")
    public ResponseEntity<RegistrationResponse> completeRegistration(
            @RequestBody CompleteRegistrationRequest registrationRequest) {
        RegistrationResponse response = registrationService.completeRegistration(
                registrationRequest.getRequest().getJwtVersion(),
                registrationRequest.getRequest().getBase64Jwt()
        );
        return ResponseEntity.ok(response);
    }
}
