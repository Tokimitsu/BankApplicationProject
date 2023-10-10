package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import com.example.bankapppro.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    TransactionDto getTransactionById(Long id);

    List<TransactionDto> getAllTransactions();

    void deleteTransaction(Long id) throws EntityNotFoundException;

    TransactionDto updateTransaction(Long id, Transaction transaction) throws EntityNotFoundException;

    TransactionDto createTransaction(Transaction transaction);
}
