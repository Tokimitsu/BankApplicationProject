package com.example.bankapppro.dto;

import lombok.Data;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;

@Data
public class TransactionDto {
    private Long id;
    private AccountDto debitAccount;
    private AccountDto creditAccount;
    private Long amount;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
