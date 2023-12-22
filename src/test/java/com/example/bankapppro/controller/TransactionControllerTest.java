package com.example.bankapppro.controller;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.service.util.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTransactionById_shouldReturnTransactionDto() {
        // Arrange
        Long transactionId = 1L;
        TransactionDto expectedTransactionDto = new TransactionDto();
        when(transactionService.getTransactionById(transactionId)).thenReturn(expectedTransactionDto);

        // Act
        ResponseEntity<TransactionDto> responseEntity = transactionController.getTransactionById(transactionId);

        // Assert
        assertEquals(ResponseEntity.ok(expectedTransactionDto), responseEntity);
    }

    @Test
    void findAllTransactionsWhereAccountIdIs_shouldReturnFilteredTransactions() {
        // Arrange
        Long accountId = 1L;
        List<TransactionDto> fakeTransactions = Arrays.asList(
                new TransactionDto(),
                new TransactionDto()
        );

        when(transactionService.findAllTransactionsWhereAccountIdIs(accountId)).thenReturn(fakeTransactions);

        // Act
        ResponseEntity<List<TransactionDto>> responseEntity = transactionController.findAllTransactionsWhereAccountIdIs(accountId);

        // Assert
        assertEquals(ResponseEntity.ok(fakeTransactions), responseEntity);
    }
}
