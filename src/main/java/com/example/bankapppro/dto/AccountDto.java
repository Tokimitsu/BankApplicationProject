package com.example.bankapppro.dto;

import com.example.bankapppro.entity.AccountStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AccountDto {
    private Long id;
    private ClientDto client;
    private String name;
    private AccountStatus status;
    private Long balance;
    private Integer currencyCode;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
