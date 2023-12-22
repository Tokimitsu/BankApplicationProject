package com.example.bankapppro.service.impl;

import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClientsWithBalanceGreaterThan_shouldReturnFilteredClients() {
        // Arrange
        double minBalance = 1000.0;

        // Mock clients and accounts
        Client client1 = new Client();
        client1.setId(1L);
        Account account1 = new Account();
        account1.setBalance(1500L);
        client1.setAccounts(List.of(account1));

        Client client2 = new Client();
        client2.setId(2L);
        Account account2 = new Account();
        account2.setBalance(800L);
        client2.setAccounts(List.of(account2));

        List<Client> allClients = Arrays.asList(client1, client2);
        List<Client> expectedFilteredClients = List.of(client1);

        when(clientRepository.findAll()).thenReturn(allClients);

        // Act
        List<Client> result = clientService.getClientsWithBalanceGreaterThan(minBalance);

        // Assert
        assertEquals(expectedFilteredClients, result);
    }
}
