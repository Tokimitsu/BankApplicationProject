package com.example.bankapppro.service.impl;

import com.example.bankapppro.entity.Client;
import com.example.bankapppro.repository.ClientRepository;
import com.example.bankapppro.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClientsWithBalanceGreaterThan(double minBalance) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return clients.stream()
                .filter(c -> c.getAccounts().stream().anyMatch(cb -> cb.getBalance() > minBalance))
                .collect(Collectors.toList());
    }
}