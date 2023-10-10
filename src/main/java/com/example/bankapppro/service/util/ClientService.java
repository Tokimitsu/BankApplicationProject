package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.EntityNotFoundException;

import java.util.List;

public interface ClientService {
    ClientDto getClientById(Long id);

    ClientDto addNewClient(Client client);

    ClientDto updateClient(Long id, Client client) throws EntityNotFoundException;

    void removeClientById(Long id) throws EntityNotFoundException;

    List<ClientDto> getAllClients();
}
