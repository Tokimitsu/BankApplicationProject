package com.example.bankapppro.controller;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.TransactionMapper;
import com.example.bankapppro.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public TransactionDto getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    //TODO findAllTransactionsWhereClientIdIs...
//    @PostMapping
//    public TransactionDto createTransaction(@RequestBody Transaction transaction) {
//        return transactionService.createTransaction(transaction);
//    }
//
//    @PutMapping("/{id}")
//    public TransactionDto updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) throws EntityNotFoundException {
//      return transactionService.updateTransaction(id, transaction);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTransaction(@PathVariable Long id) throws EntityNotFoundException {
//        transactionService.deleteTransaction(id);
//    }
//
//    @GetMapping("/all")
//    public List<TransactionDto> getAllTransactions() {
//     return transactionService.getAllTransactions();
//    }
}
