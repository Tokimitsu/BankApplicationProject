package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountMapperTest {

    private AccountMapper accountMapper;

    @BeforeEach
    public void setUp() {
        accountMapper = Mappers.getMapper(AccountMapper.class);
    }

    @Test
    public void testEntityToDto() {
        // Arrange
        Account account = new Account();
        account.setId(1L);
        account.setName("Sample Account");

        // Act
        AccountDto accountDto = accountMapper.entityToDto(account);

        // Assert
        assertEquals(account.getId(), accountDto.getId());
        assertEquals(account.getName(), accountDto.getName());
    }

    @Test
    public void testToDtoList() {
        // Arrange
        Account account1 = new Account();
        account1.setId(1L);
        account1.setName("Account 1");

        Account account2 = new Account();
        account2.setId(2L);
        account2.setName("Account 2");

        List<Account> accountList = Arrays.asList(account1, account2);

        // Act
        List<AccountDto> accountDtoList = accountMapper.toDtoList(accountList);

        // Assert
        assertEquals(accountList.size(), accountDtoList.size());
        assertEquals(accountList.get(0).getId(), accountDtoList.get(0).getId());
        assertEquals(accountList.get(0).getName(), accountDtoList.get(0).getName());
    }
}
