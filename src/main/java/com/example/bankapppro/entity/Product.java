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


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @Column(name = "min_interest_rate")
    private Integer minInterestRate;

    @Column(name = "max_offer_limit")
    private Long maxOfferLimit;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Agreement> agreements;

    @PrePersist
    private void prePersist() {
        createdAt = updatedAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = Timestamp.from(Instant.now());
    }
}