package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientMapperTest {

    private ClientMapper clientMapper;

    @BeforeEach
    public void setUp() {
        clientMapper = Mappers.getMapper(ClientMapper.class);
    }

    @Test
    public void testEntityListToDtoList() {
        // Arrange
        Client client1 = new Client();
        client1.setId(1L);
        client1.setFirstName("Client 1");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setFirstName("Client 2");

        List<Client> clientList = Arrays.asList(client1, client2);

        // Act
        List<ClientDto> clientDtoList = clientMapper.entityListToDtoList(clientList);

        // Assert
        assertEquals(clientList.size(), clientDtoList.size());
        assertEquals(clientList.get(0).getId(), clientDtoList.get(0).getId());
        assertEquals(clientList.get(0).getFirstName(), clientDtoList.get(0).getFirstName());
    }
}
