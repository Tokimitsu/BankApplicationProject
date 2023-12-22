package com.example.bankapppro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Agreement> agreements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "debitAccount")
    private List<Transaction> debitTransactions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creditAccount")
    private List<Transaction> creditTransactions;

    @PrePersist
    private void prePersist() {
        createdAt = updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}
