package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.AccountMapper;
import com.example.bankapppro.service.util.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

        @PostMapping()
    public AccountDto createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

//    @PutMapping("/{id}")
//    public AccountDto updateAccount(@PathVariable Long id, @RequestBody Account account) throws EntityNotFoundException {
//       return accountService.updateAccount(id, account);
//    }
//
//    @GetMapping("/all")
//    public List<AccountDto> getAllAccounts() {
//       return accountService.getAllAccounts();
//    }
//    @DeleteMapping("/{id}")
//    public void deleteAccount(@PathVariable Long id) throws EntityNotFoundException {
//        accountService.deleteAccount(id);
//    }
    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }



    //TODO getAllAccountWhereStatusIs Active/Remote/Pending/Blocked
}