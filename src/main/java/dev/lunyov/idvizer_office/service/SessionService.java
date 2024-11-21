package dev.lunyov.idvizer_office.service;

import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.entity.User;
import dev.lunyov.idvizer_office.repositoryWrapper.SessionRepositoryWrapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

    private final SessionRepositoryWrapper sessionRepositoryWrapper;

    public SessionService(SessionRepositoryWrapper sessionRepositoryWrapper) {
        this.sessionRepositoryWrapper = sessionRepositoryWrapper;
    }

    public Session createSession(User user) {
        Session session = new Session();
        session.setUserId(user.getId());
        session.setAuthToken(UUID.randomUUID().toString());
        session.setRefreshToken(UUID.randomUUID().toString());
        return sessionRepositoryWrapper.save(session);
    }

    public Optional<Session> findSessionById(UUID sessionId) {
        return sessionRepositoryWrapper.findById(sessionId);
    }

    public void saveSession(Session session) {
        sessionRepositoryWrapper.save(session);
    }

    public boolean validateAuthToken(UUID sessionId, String authToken) {
        return sessionRepositoryWrapper.findById(sessionId)
                .map(session -> session.getAuthToken().equals(authToken))
                .orElse(false);
    }

    public Session refreshSession(UUID sessionId, String refreshToken) {
        Session session = sessionRepositoryWrapper.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Сесія не знайдена"));

        if (!session.getRefreshToken().equals(refreshToken)) {
            throw new IllegalArgumentException("Некоректний refreshToken");
        }

        session.setAuthToken(UUID.randomUUID().toString());
        return sessionRepositoryWrapper.save(session);
    }
}
