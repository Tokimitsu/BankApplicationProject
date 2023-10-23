package com.example.bankapppro.service.util;

import com.example.bankapppro.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClientsWithBalanceGreaterThan(double minBalance);
}
