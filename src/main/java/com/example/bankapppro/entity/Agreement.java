package com.example.bankapppro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "agreements")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;

    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AgreementStatus status;

    @Column(name = "interest_rate")
    private Integer interestRate;

    @Column(name = "debt")
    private Long debt;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    private void prePersist() {
        createdAt = updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}
