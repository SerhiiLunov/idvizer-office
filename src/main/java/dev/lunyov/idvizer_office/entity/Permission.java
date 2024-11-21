package dev.lunyov.idvizer_office.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, length = 50)
    private String alias;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "create_date_time", columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime createDateTime;

    @Column(name = "update_date_time", columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime updateDateTime;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createDateTime = now;
        updateDateTime = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updateDateTime = LocalDateTime.now();
    }
}

