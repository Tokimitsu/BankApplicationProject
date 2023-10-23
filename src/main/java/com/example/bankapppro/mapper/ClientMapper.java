package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    List<ClientDto> entityListToDtoList(List<Client> agreements);
}
