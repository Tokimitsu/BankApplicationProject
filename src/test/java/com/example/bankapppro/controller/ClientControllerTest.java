package com.example.bankapppro.controller;

import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.entity.ClientStatus;
import com.example.bankapppro.repository.ClientRepository;
import com.example.bankapppro.service.util.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository mock =  mock(ClientRepository.class);

    @Test
    void getClientsWithBalanceGreaterThan() {
        // Arrange
        long minBalance = 1000L;
        List<Client> clients = new ArrayList<>();

        // Створюємо клієнта з балансом більше `minBalance`
        Client client1 = new Client();
        client1.setId(1L);
        client1.setAccounts(new ArrayList<>());
        Account account1 = new Account();
        account1.setBalance(minBalance + 100L);
        client1.getAccounts().add(account1);
        clients.add(client1);

        // Створюємо клієнта з балансом менше `minBalance`
        Client client2 = new Client();
        client2.setId(2L);
        client2.setAccounts(new ArrayList<>());
        Account account2 = new Account();
        account2.setBalance(minBalance - 100L);
        client2.getAccounts().add(account2);
        clients.add(client2);

        when(mock.findAll()).thenReturn(clients);
        when()

        // Act
        List<Client> result = clientService.getClientsWithBalanceGreaterThan(minBalance);

        // Assert
        assertEquals(1, result.size()); // Очікуємо, що повернеться лише один клієнт
        assertEquals(client1, result.get(0)); // Перевірка, чи це той самий клієнт
    }
}