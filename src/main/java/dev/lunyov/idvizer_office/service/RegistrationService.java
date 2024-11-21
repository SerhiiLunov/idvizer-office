package dev.lunyov.idvizer_office.service;

import dev.lunyov.idvizer_office.util.ResponseType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import dev.lunyov.idvizer_office.entity.User;
import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.dto.RegistrationResponse;

import java.util.Base64;
import java.util.UUID;

@Service
public class RegistrationService {

    private final JwtService jwtService;
    private final EmailService emailService;
    private final UserService userService;
    private final SessionService sessionService;

    @Value("${app.domain}")
    private String domain;

    public RegistrationService(JwtService jwtService,
                               EmailService emailService,
                               UserService userService,
                               SessionService sessionService) {
        this.jwtService = jwtService;
        this.emailService = emailService;
        this.userService = userService;
        this.sessionService = sessionService;
    }

    public void initiateRegistration(String email, String phone) {
        String jwtToken = jwtService.generateJwtToken(email, phone);
        String jwtVersion = UUID.randomUUID().toString();
        String base64Jwt = Base64.getEncoder().encodeToString(jwtToken.getBytes());

        String registrationLink = String.format("https://%s/registration?jwtVersion=%s&base64Jwt=%s",
                domain, jwtVersion, base64Jwt);

        String subject = "Registration in the system";
        String message = String.format("Follow the link to complete registration: %s", registrationLink);

        emailService.sendEmail(email, subject, message);
    }

    public RegistrationResponse completeRegistration(String jwtVersion, String base64Jwt) {
        String jwtToken = new String(Base64.getDecoder().decode(base64Jwt));
        var userData = jwtService.parseToken(jwtToken);

        String email = (String) userData.get("email");
        String phone = (String) userData.get("phone");

        User user = userService.findOrCreateUser(email, phone);
        Session session = sessionService.createSession(user);
        UUID requestId = UUID.randomUUID();

        return new RegistrationResponse(
                ResponseType.SUCCESS,
                requestId,
                new RegistrationResponse.RegistrationResponseData(
                        session.getId(),
                        session.getAuthToken(),
                        session.getRefreshToken()
                )
        );
    }
}