package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    AgreementDto entityToDto(Agreement agreement);

    Agreement dtoToEntity(AgreementDto agreementDto);

    List<AgreementDto> entityListToDTOList(List<Agreement> agreements);
}