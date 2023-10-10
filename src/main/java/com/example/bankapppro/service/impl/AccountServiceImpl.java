package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.AccountMapper;
import com.example.bankapppro.repository.AccountRepository;
import com.example.bankapppro.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    public AccountDto updateAccount(Long id, Account account) throws EntityNotFoundException {
        Account updatedAccount = accountRepository.findById(id).orElse(null);
        if (updatedAccount == null) {
            throw new EntityNotFoundException();
        }
        updatedAccount.setClient(account.getClient());
        updatedAccount.setName(account.getName());
        updatedAccount.setStatus(account.getStatus());
        updatedAccount.setBalance(account.getBalance());
        updatedAccount.setCurrencyCode(account.getCurrencyCode());
        accountRepository.save(updatedAccount);
        return accountMapper.entityToDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) throws EntityNotFoundException {
        if (!accountRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        accountRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accountMapper.toDtoList(accounts);
    }
}
