package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.mapper.ClientMapper;
import com.example.bankapppro.service.util.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auth/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping("/{balance}")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Get Clients With Balance Greater Than")
    public ResponseEntity<List<ClientDto>> getClientsWithBalanceGreaterThan
            (@PathVariable(name = "balance") double balance) {
        if (balance < 0) {
            return ResponseEntity.badRequest().build();
        }

        List<Client> clients = clientService.getClientsWithBalanceGreaterThan(balance);

        if (clients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ClientDto> clientDTOs = clientMapper.entityListToDtoList(clients);
        return ResponseEntity.ok(clientDTOs);
    }
}
