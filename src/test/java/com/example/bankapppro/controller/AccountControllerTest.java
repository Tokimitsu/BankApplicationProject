package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.service.util.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    @Test
    @WithMockUser(authorities = "user:write")
    void createAccount() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        Account account = new Account();
        account.setId(1L);
        account.setName("TestAccount");

        when(accountService.createAccount(any(Account.class))).thenReturn(new AccountDto());

        mockMvc.perform(post("/auth/accounts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(account)))
                .andExpect(status().isOk());

        verify(accountService, times(1)).createAccount(any(Account.class));
    }

    @Test
    @WithMockUser(authorities = "user:read")
    void getAccountById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        when(accountService.getAccountById(1L)).thenReturn(new AccountDto());

        mockMvc.perform(get("/auth/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(accountService, times(1)).getAccountById(1L);
    }

    @Test
    @WithMockUser(authorities = "user:write")
    void getAllActiveAccounts() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        when(accountService.getAllActiveAccounts()).thenReturn(Collections.singletonList(new AccountDto()));

        mockMvc.perform(get("/auth/accounts/active"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(accountService, times(1)).getAllActiveAccounts();
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
