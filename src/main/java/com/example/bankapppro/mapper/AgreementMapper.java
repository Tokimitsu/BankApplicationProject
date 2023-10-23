package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    AgreementDto entityToDto(Agreement agreement);
}