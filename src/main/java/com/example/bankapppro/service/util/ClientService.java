package com.example.bankapppro.service.util;

import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.ClientNotFoundException;

public interface ClientService {
    Client getClientById(Long id);

    Client addNewClient(Client client);

    Client updateClient(Long id, Client client) throws ClientNotFoundException;

    void removeClientById(Long id) throws ClientNotFoundException;
}
