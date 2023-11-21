package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAccountTest() throws Exception {
        //given
        AccountDto accountDto = new AccountDto();
        String accountStr = null;
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/account")
                        .content(accountStr))
                .andReturn();
        //then
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void getAccountById() {
    }

    @Test
    void getAllActiveAccounts() {
    }
}