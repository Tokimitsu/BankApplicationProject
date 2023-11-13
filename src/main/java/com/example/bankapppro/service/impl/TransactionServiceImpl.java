package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import com.example.bankapppro.mapper.TransactionMapper;
import com.example.bankapppro.repository.TransactionRepository;
import com.example.bankapppro.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDto getTransactionById(Long id) {
        return transactionMapper.entityToDto(transactionRepository.findById(id)
                .orElse(null)); // throw exception TODO
    }


    @Override
    @Transactional
    public List<TransactionDto> findAllTransactionsWhereAccountIdIs(Long id) {
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
        return transactionMapper.entityListToDtoList(transactions.stream()
                .filter(transaction -> transaction.getCreditAccount().getId().equals(id)
                        || transaction.getDebitAccount().getId().equals(id))
                .toList());
    }
}