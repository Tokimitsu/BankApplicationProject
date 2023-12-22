package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.mapper.ClientMapper;
import com.example.bankapppro.service.util.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientController clientController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClientsWithNegativeBalance_shouldReturnBadRequest() {
        // Arrange
        double negativeBalance = -100.0;

        // Act
        ResponseEntity<List<ClientDto>> responseEntity = clientController.getClientsWithBalanceGreaterThan(negativeBalance);

        // Assert
        assertEquals(ResponseEntity.badRequest().build(), responseEntity);
    }

    @Test
    void getClientsWithNonexistentBalance_shouldReturnNotFound() {
        // Arrange
        double minBalance = 100.0;
        when(clientService.getClientsWithBalanceGreaterThan(anyDouble())).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<ClientDto>> responseEntity = clientController.getClientsWithBalanceGreaterThan(minBalance);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), responseEntity);
    }
}
