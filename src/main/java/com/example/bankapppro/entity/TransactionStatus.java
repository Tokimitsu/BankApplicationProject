package com.example.bankapppro.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum TransactionStatus {
    PENDING, COMPLETED, CANCELED
}
