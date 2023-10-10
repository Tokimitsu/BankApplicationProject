package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.exception.EntityNotFoundException;

import java.util.List;

public interface AccountService {
    AccountDto getAccountById(Long id);

    AccountDto createAccount(Account account);

    AccountDto updateAccount(Long id, Account account) throws EntityNotFoundException;

    void deleteAccount(Long id) throws EntityNotFoundException;

    List<AccountDto> getAllAccounts();
}
