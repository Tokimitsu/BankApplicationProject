package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.entity.Client;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto entityToDto(Client client);

    Client dtoToEntity(ClientDto clientDto);

    List<ClientDto> entityListToDtoList(List<Client> agreements);
}
