package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.AccountStatus;
import com.example.bankapppro.mapper.AccountMapper;
import com.example.bankapppro.repository.AccountRepository;
import com.example.bankapppro.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AccountDto getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::entityToDto)
                .orElse(null);
    }

    @Override
    public AccountDto createAccount(Account account) {
        accountRepository.save(account);
        return accountMapper.entityToDto(account);
    }

    @Override
    public List<AccountDto> getAllActiveAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accountMapper.toDtoList(accounts.stream()
                .filter(a -> a.getStatus().equals(AccountStatus.ACTIVE))
                .collect(Collectors.toList()));
    }
}