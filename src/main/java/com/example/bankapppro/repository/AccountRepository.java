package com.example.bankapppro.repository;

import com.example.bankapppro.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
}