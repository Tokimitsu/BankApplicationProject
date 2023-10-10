package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.ClientMapper;
import com.example.bankapppro.repository.ClientRepository;
import com.example.bankapppro.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        System.out.println(client);
        ClientDto clientDto = clientMapper.entityToDto(client);
        System.out.println(clientDto);
      return clientDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDto addNewClient(Client client) {
        clientRepository.save(client);
        return clientMapper.entityToDto(client);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDto updateClient(Long id, Client client) throws EntityNotFoundException {
        Client updatedClient = clientRepository.findById(id).orElse(null);
        if (updatedClient == null) {
            throw new EntityNotFoundException();
        }
        updatedClient.setFirstName(client.getFirstName());
        updatedClient.setLastName(client.getLastName());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setAddress(client.getAddress());
        updatedClient.setPhone(client.getPhone());
        clientRepository.save(updatedClient);
        return clientMapper.entityToDto(updatedClient);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeClientById(Long id) throws EntityNotFoundException {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return clientMapper.entityListToDtoList(clients);
    }
}
