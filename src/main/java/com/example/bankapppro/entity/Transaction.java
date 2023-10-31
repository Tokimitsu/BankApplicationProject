package com.example.bankapppro.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "debit_account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Account debitAccount;

    @JoinColumn(name = "credit_account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Account creditAccount;

    @Column(name = "amount")
    @NonNull
    private Long amount;

    @Column(name = "description")
    @NonNull
    private String description;

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
