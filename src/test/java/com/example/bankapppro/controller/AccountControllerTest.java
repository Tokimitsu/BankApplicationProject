package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.entity.Account;
import com.example.bankapppro.entity.AccountStatus;
import com.example.bankapppro.entity.Client;
import com.example.bankapppro.entity.ClientStatus;
import com.example.bankapppro.service.util.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountService accountService;
    private final Client client = mock();

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createAccountTest() throws Exception {
        Account account = new Account();
        account.setName("Test Account");
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(777L);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/auth/accounts/create")
                        .content(asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Отримуємо JSON-відповідь
        String responseJson = result.getResponse().getContentAsString();

        // Парсимо JSON-відповідь в об'єкт AccountDto
        ObjectMapper objectMapper = new ObjectMapper();
        AccountDto accountDto = objectMapper.readValue(responseJson, AccountDto.class);

        // Перевіряємо значення полів AccountDto
        Assertions.assertEquals("Test Account", accountDto.getName());
        Assertions.assertEquals(777L, accountDto.getBalance());
    }
        // Допоміжний метод для перетворення об'єкта в JSON
        public static String asJsonString ( final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    @Test
    void getAccountById() {
    }

    @Test
    void getAllActiveAccounts() {
    }
}