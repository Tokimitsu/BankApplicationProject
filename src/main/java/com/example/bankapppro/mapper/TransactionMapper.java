package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.TransactionDto;
import com.example.bankapppro.entity.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    List<TransactionDto> entityListToDtoList(List<Transaction> transactions);

    TransactionDto entityToDto(Transaction transaction);
}