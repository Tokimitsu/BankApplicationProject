package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto getAccountById(Long id);

    AccountDto createAccount(Account account);

    List<AccountDto> getAllActiveAccounts();
}
