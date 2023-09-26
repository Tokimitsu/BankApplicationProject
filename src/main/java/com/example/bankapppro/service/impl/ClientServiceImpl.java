package com.example.bankapppro.service.impl;

import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.ClientNotFoundException;
import com.example.bankapppro.repository.ClientRepository;
import com.example.bankapppro.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Client updateClient(Long id, Client client) throws ClientNotFoundException {
        Client c = clientRepository.findById(id).orElse(null);
        if (c == null) {
            throw new ClientNotFoundException();
        }
        if (client.getFirstName() != null) {
            c.setFirstName(client.getFirstName());
        }
        if (client.getLastName() != null) {
            c.setLastName(client.getLastName());
        }
        return clientRepository.save(c);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeClientById(Long id) throws ClientNotFoundException {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        clientRepository.deleteById(id);
    }
}
