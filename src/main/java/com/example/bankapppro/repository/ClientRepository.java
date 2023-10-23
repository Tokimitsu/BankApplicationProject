package com.example.bankapppro.repository;

import com.example.bankapppro.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
