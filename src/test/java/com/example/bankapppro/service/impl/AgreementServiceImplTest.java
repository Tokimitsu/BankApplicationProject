package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.mapper.AgreementMapper;
import com.example.bankapppro.repository.AgreementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AgreementServiceImplTest {

    @Mock
    private AgreementRepository agreementRepository;

    @Mock
    private AgreementMapper agreementMapper;

    @InjectMocks
    private AgreementServiceImpl agreementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAgreementById_shouldReturnAgreementDto() {
        // Arrange
        Long agreementId = 1L;

        // Mock the agreement entity and DTO
        Agreement agreement = new Agreement();
        AgreementDto expectedAgreementDto = new AgreementDto();

        when(agreementRepository.findById(agreementId)).thenReturn(Optional.of(agreement));
        when(agreementMapper.entityToDto(agreement)).thenReturn(expectedAgreementDto);

        // Act
        AgreementDto result = agreementService.getAgreementById(agreementId);

        // Assert
        assertEquals(expectedAgreementDto, result);
    }
}
