package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto entityToDto(Account account);

    List<AccountDto> toDtoList(List<Account> accounts);
}
