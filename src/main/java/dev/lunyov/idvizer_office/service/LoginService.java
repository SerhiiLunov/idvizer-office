package dev.lunyov.idvizer_office.service;

import dev.lunyov.idvizer_office.dto.RegistrationResponse;
import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.entity.User;
import dev.lunyov.idvizer_office.util.ResponseType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
public class LoginService {

    private final JwtService jwtService;
    private final EmailService emailService;
    private final UserService userService;
    private final SessionService sessionService;

    @Value("${app.domain}")
    private String domain;

    public LoginService(JwtService jwtService, EmailService emailService, UserService userService, SessionService sessionService) {
        this.jwtService = jwtService;
        this.emailService = emailService;
        this.userService = userService;
        this.sessionService = sessionService;
    }

    public void sendLoginLink(String email) {
        String jwtToken = jwtService.generateJwtToken(email);
        String jwtVersion = UUID.randomUUID().toString();
        String base64Jwt = Base64.getEncoder().encodeToString(jwtToken.getBytes());

        String loginLink = String.format("https://%s/login?jwtVersion=%s&jwt=%s", domain, jwtVersion, base64Jwt);

        String subject = "Логін у систему";
        String message = String.format("Перейдіть за посиланням для входу: %s", loginLink);

        emailService.sendEmail(email, subject, message);
    }

    public RegistrationResponse completeLogin(String jwtVersion, String base64Jwt) {
        String jwtToken = new String(Base64.getDecoder().decode(base64Jwt));
        var userData = jwtService.parseToken(jwtToken);

        String email = (String) userData.get("email");

        User user = userService.findUserByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Користувача не знайдено");
        }

        Session session = sessionService.createSession(user);

        return new RegistrationResponse(
                ResponseType.SUCCESS,
                UUID.randomUUID(),
                new RegistrationResponse.RegistrationResponseData(
                        session.getId(),
                        session.getAuthToken(),
                        session.getRefreshToken()
                )
        );
    }
}