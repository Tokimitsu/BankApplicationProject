package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AccountDto;
import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.AgreementStatus;
import com.example.bankapppro.service.util.AgreementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AgreementController.class)
@AutoConfigureMockMvc
class AgreementControllerTest {

    @MockBean
    private AgreementService agreementService;

    @InjectMocks
    private AgreementController agreementController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(authorities = "user:read")
    void givenValidAgreementId_whenGetAgreementById_thenStatus200() throws Exception {
        // Arrange
        Long validAgreementId = 1L;
        AgreementDto agreementDto = createMockAgreementDto(validAgreementId);

        // Mock the service method
        when(agreementService.getAgreementById(anyLong())).thenReturn(agreementDto);

        // Act & Assert
        mockMvc.perform(get("/agreements/{id}", validAgreementId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(validAgreementId))
                .andExpect(jsonPath("$.account").exists())
                .andExpect(jsonPath("$.product").exists())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.interestRate").exists())
                .andExpect(jsonPath("$.debt").exists())
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists());
    }

    @Test
    @WithMockUser(authorities = "user:read")
    void givenInvalidAgreementId_whenGetAgreementById_thenStatus404() throws Exception {
        // Arrange
        Long invalidAgreementId = 999L;

        // Mock the service method to return null, simulating a not found scenario
        when(agreementService.getAgreementById(anyLong())).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/agreements/{id}", invalidAgreementId))
                .andExpect(status().isNotFound());
    }

    private AgreementDto createMockAgreementDto(Long id) {
        AgreementDto agreementDto = new AgreementDto();
        agreementDto.setId(id);
        agreementDto.setAccount(new AccountDto());
        agreementDto.setProduct(new ProductDto());
        agreementDto.setStatus(AgreementStatus.ACTIVE);
        agreementDto.setInterestRate(5);
        agreementDto.setDebt(1000L);
        agreementDto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        agreementDto.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return agreementDto;
    }
}
