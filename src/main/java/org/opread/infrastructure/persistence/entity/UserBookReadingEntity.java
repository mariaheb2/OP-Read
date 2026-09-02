package org.opread.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.opread.domain.model.ReadingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "tb_user_book_readings",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "book_id"}) // Um usuário só tem 1 status por livro
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBookReadingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingStatus status;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}