package dev.lunyov.idvizer_office.repository;

import dev.lunyov.idvizer_office.entity.Session;
import dev.lunyov.idvizer_office.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionRepository extends JpaRepository<Session, UUID> {
}
