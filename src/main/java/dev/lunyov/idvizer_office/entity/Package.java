package dev.lunyov.idvizer_office.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;

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