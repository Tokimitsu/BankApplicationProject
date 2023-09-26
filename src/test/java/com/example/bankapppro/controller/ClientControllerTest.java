package com.example.bankapppro.controller;

import com.example.bankapppro.entity.Client;
import com.example.bankapppro.entity.ClientStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    void addNewClient() throws Exception {
        Client client = new Client();
        client.setStatus(ClientStatus.ACTIVE);
        client.setFirstName("Joe");
        client.setLastName("Oej");
        client.setAddress("sdfsdf");
        client.setPhone("sdfsdf");
        client.setEmail("sdfsdf");
        client.setPassword("sdfsdf");

        String requestJson = mapper.writeValueAsString(client);
        MvcResult createResult = mockMvc.perform(
                MockMvcRequestBuilders.put("/auth/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        Client createdClient = mapper.readValue(createResult.getResponse().getContentAsString(), Client.class);

        MvcResult getResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/auth/clients/" + createdClient.getId())
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        Client getClient = mapper.readValue(getResult.getResponse().getContentAsString(), Client.class);
        Assertions.assertEquals(getClient.getId(), createdClient.getId());
    }
}