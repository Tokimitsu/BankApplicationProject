package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {
    AccountDto entityToDto(Account account);

    Account dtoToEntity(AccountDto accountDto);

    List<AccountDto> toDtoList(List<Account> accounts);
}
