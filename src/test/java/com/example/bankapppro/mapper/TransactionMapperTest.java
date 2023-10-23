package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionMapperTest {

    private TransactionMapper transactionMapper;

    @BeforeEach
    public void setUp() {
        transactionMapper = Mappers.getMapper(TransactionMapper.class);
    }

    @Test
    public void testEntityListToDtoList() {
        // Arrange
        Transaction transaction1 = new Transaction();
        transaction1.setId(1L);
        transaction1.setDescription("Transaction 1");

        Transaction transaction2 = new Transaction();
        transaction2.setId(2L);
        transaction2.setDescription("Transaction 2");

        List<Transaction> transactionList = Arrays.asList(transaction1, transaction2);

        // Act
        List<TransactionDto> transactionDtoList = transactionMapper.entityListToDtoList(transactionList);

        // Assert
        assertEquals(transactionList.size(), transactionDtoList.size());
        assertEquals(transactionList.get(0).getId(), transactionDtoList.get(0).getId());
        assertEquals(transactionList.get(0).getDescription(), transactionDtoList.get(0).getDescription());
    }

    @Test
    public void testEntityToDto() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setDescription("Sample Transaction");

        // Act
        TransactionDto transactionDto = transactionMapper.entityToDto(transaction);

        // Assert
        assertEquals(transaction.getId(), transactionDto.getId());
        assertEquals(transaction.getDescription(), transactionDto.getDescription());
    }
}
