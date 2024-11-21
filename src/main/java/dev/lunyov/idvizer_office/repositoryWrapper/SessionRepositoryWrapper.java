package dev.lunyov.idvizer_office.repositoryWrapper;

import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SessionRepositoryWrapper {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionRepositoryWrapper(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    public Optional<Session> findById(UUID sessionId) {
        return sessionRepository.findById(sessionId);
    }
}