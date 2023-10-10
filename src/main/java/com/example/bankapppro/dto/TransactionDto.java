package com.example.bankapppro.dto;

import com.example.bankapppro.entity.Account;
import lombok.Data;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.sql.Timestamp;

@Data
public class TransactionDto {
private Long id;
private AccountDto debitAccount;
private AccountDto creditAccount;
private TransactionStatus status;
private Long amount;
private String description;
private Timestamp createdAt;
private Timestamp updatedAt;
}