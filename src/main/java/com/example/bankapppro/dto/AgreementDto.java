package com.example.bankapppro.dto;

import com.example.bankapppro.entity.AgreementStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AgreementDto {
    private Long id;
    private AccountDto account;
    private ProductDto product;
    private AgreementStatus status;
    private Integer interestRate;
    private Long debt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
