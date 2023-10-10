package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.TransactionMapper;
import com.example.bankapppro.repository.TransactionRepository;
import com.example.bankapppro.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDto getTransactionById(Long id) {
        return transactionMapper.entityToDto(transactionRepository
                .findById(id)
                .orElse(null));
    }

    @Override
    public TransactionDto createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transactionMapper.entityToDto(transaction);
    }

    @Override
    public TransactionDto updateTransaction(Long id, Transaction transaction) throws EntityNotFoundException {
        Transaction updatedTransaction = transactionRepository.findById(id)
                .orElse(null);
        if (updatedTransaction == null) {
            throw new EntityNotFoundException();
        }
        updatedTransaction.setStatus(transaction.getStatus());
        updatedTransaction.setAmount(transaction.getAmount());
        updatedTransaction.setDescription(transaction.getDescription());
        transactionRepository.save(updatedTransaction);
        return transactionMapper.entityToDto(updatedTransaction);
    }

    @Override
    public void deleteTransaction(Long id) throws EntityNotFoundException {
        if (!transactionRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionMapper.entityListToDtoList((List<Transaction>) transactionRepository.findAll());
    }
}
