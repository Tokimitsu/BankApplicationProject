package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ClientDto;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.ClientMapper;
import com.example.bankapppro.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

//TODO getAllClientsWhereBalanceMoreThan
//    @GetMapping("/{id}")
//    public ClientDto getClientById(@PathVariable Long id) {
//        return clientService.getClientById(id);
//    }
//
//    @PutMapping
//    public ClientDto createClient(@RequestBody Client client) {
//        return clientService.addNewClient(client);
//    }
//
//    @PostMapping("/{id}")
//    public ClientDto updateClient(@PathVariable Long id, @RequestBody Client client) throws EntityNotFoundException {
//        return clientService.updateClient(id, client);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteClient(@PathVariable Long id) throws EntityNotFoundException {
//        clientService.removeClientById(id);
//    }
//
//    @GetMapping("/all")
//    public List<ClientDto> getAllClients() {
//        return clientService.getAllClients();
//    }
}
