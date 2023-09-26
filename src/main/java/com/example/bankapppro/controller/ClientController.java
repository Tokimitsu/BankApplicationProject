package com.example.bankapppro.controller;

import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.exception.ClientNotFoundException;
import com.example.bankapppro.service.util.AccountService;
import com.example.bankapppro.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("")
    public Client addNewClient(@RequestBody Client client) {
        return clientService.addNewClient(client);
    }

    @PostMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody Client client) throws ClientNotFoundException {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable("id") Long id) throws ClientNotFoundException {
        clientService.removeClientById(id);
    }
}
