package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.AccountStatus;
import com.example.bankapppro.mapper.AccountMapper;
import com.example.bankapppro.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAccountById_shouldReturnAccountDtoIfExists() {
        // Arrange
        Long accountId = 1L;
        Account account = new Account();
        AccountDto expectedAccountDto = new AccountDto();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountMapper.entityToDto(account)).thenReturn(expectedAccountDto);

        // Act
        AccountDto result = accountService.getAccountById(accountId);

        // Assert
        assertEquals(expectedAccountDto, result);
    }

    @Test
    void getAccountById_shouldReturnNullIfNotExists() {
        // Arrange
        Long nonExistentAccountId = 2L;
        when(accountRepository.findById(nonExistentAccountId)).thenReturn(Optional.empty());

        // Act
        AccountDto result = accountService.getAccountById(nonExistentAccountId);

        // Assert
        assertNull(result);
    }

    @Test
    void createAccount_shouldSaveAccountAndReturnAccountDto() {
        // Arrange
        Account account = new Account();
        AccountDto expectedAccountDto = new AccountDto();
        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.entityToDto(account)).thenReturn(expectedAccountDto);

        // Act
        AccountDto result = accountService.createAccount(account);

        // Assert
        assertEquals(expectedAccountDto, result);
        verify(accountRepository).save(account);
    }

    @Test
    void getAllActiveAccounts_shouldReturnFilteredAccountDtos() {
        // Arrange
        List<Account> activeAccounts = new ArrayList<>(Arrays.asList(
                new Account(),
                new Account()
        ));
        // Add an account with null status
        Account nullAccount = new Account();
        nullAccount.setStatus(AccountStatus.BLOCKED);
        activeAccounts.add(nullAccount);

        List<AccountDto> expectedActiveAccountDtos = Arrays.asList(
                new AccountDto(),
                new AccountDto()
        );
        when(accountRepository.findAll()).thenReturn(activeAccounts);
        when(accountMapper.toDtoList(activeAccounts
                .stream()
                .filter(account -> account.getStatus() != null && account.getStatus().equals(AccountStatus.ACTIVE))
                .collect(Collectors.toList())))
                .thenReturn(expectedActiveAccountDtos);

        // Act
        List<AccountDto> result = accountService.getAllActiveAccounts();

        // Assert
        assertEquals(expectedActiveAccountDtos, result);
    }
}
