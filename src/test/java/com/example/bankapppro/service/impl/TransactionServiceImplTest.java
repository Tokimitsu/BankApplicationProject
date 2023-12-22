package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.Transaction;
import com.example.bankapppro.mapper.TransactionMapper;
import com.example.bankapppro.repository.TransactionRepository;
import com.example.bankapppro.service.impl.TransactionServiceImpl;
import com.example.bankapppro.service.util.TransactionService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionServiceImplTest {
    private final TransactionRepository transactionRepository = mock(TransactionRepository.class);
    private final TransactionMapper transactionMapper = mock(TransactionMapper.class);
    private final TransactionService transactionService = new TransactionServiceImpl(transactionRepository, transactionMapper);

    @Test
    void getTransactionById_shouldReturnTransactionDto() {
        // Arrange
        Long transactionId = 1L;

        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        TransactionDto expectedTransactionDto = new TransactionDto();

        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));
        when(transactionMapper.entityToDto(transaction)).thenReturn(expectedTransactionDto);

        // Act
        TransactionDto result = transactionService.getTransactionById(transactionId);

        // Assert
        assertEquals(expectedTransactionDto, result);
    }
    @Test
    void findAllTransactionsWhereAccountIdIs_shouldReturnFilteredTransactionDtoList() {
        // Arrange
        Long accountId = 1L;

        Account account1 = new Account();
        account1.setId(1L);
        Account account2 = new Account();
        account2.setId(2L);

        Transaction transaction1 = new Transaction();
        transaction1.setCreditAccount(account1);
        transaction1.setDebitAccount(account2);

        Transaction transaction2 = new Transaction();
        transaction2.setCreditAccount(account2);
        transaction2.setDebitAccount(account1);

        List<Transaction> allTransactions = Arrays.asList(transaction1, transaction2);

        List<TransactionDto> filteredTransactionDtoList = Arrays.asList(new TransactionDto(), new TransactionDto());

        when(transactionRepository.findAll()).thenReturn(allTransactions);
        when(transactionMapper.entityListToDtoList(allTransactions.stream()
                .filter(transaction -> transaction.getCreditAccount().getId().equals(accountId)
                        || transaction.getDebitAccount().getId().equals(accountId))
                .toList()))
                .thenReturn(filteredTransactionDtoList);

        // Act
        List<TransactionDto> result = transactionService.findAllTransactionsWhereAccountIdIs(accountId);

        // Assert
        assertEquals(filteredTransactionDtoList, result);
    }
}
