package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.service.util.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Create Account")
    public AccountDto createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('user:read')")
    @Tag(name = "Get Account by Id")
    public AccountDto getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/active")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Get All Active Accounts")
    public List<AccountDto> getAllActiveAccounts() {
        return accountService.getAllActiveAccounts();
    }
}