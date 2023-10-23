package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    TransactionDto getTransactionById(Long id);

    List<TransactionDto> findAllTransactionsWhereAccountIdIs(Long id);
}
