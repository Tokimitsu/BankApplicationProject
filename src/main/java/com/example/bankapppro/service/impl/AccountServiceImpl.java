package com.example.bankapppro.service.impl;

import com.example.bankapppro.entity.Account;
import com.example.bankapppro.repository.AccountRepository;
import com.example.bankapppro.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
