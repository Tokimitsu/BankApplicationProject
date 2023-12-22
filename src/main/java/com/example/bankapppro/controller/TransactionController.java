package com.example.bankapppro.controller;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.service.util.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    @Tag(name = "Get transaction by id")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));

    }

    @GetMapping("/all/{account_id}")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Get all transactions where account id is")
    public ResponseEntity<List<TransactionDto>> findAllTransactionsWhereAccountIdIs(@PathVariable Long account_id) {
        return ResponseEntity.ok(transactionService.findAllTransactionsWhereAccountIdIs(account_id));
    }
}
