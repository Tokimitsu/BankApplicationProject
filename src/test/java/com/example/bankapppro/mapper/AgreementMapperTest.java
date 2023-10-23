package com.example.bankapppro.mapper;
import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgreementMapperTest {

    private AgreementMapper agreementMapper;

    @BeforeEach
    public void setUp() {
        agreementMapper = Mappers.getMapper(AgreementMapper.class);
    }

    @Test
    public void testEntityToDto() {
        // Arrange
        Agreement agreement = new Agreement();
        agreement.setId(1L);

        // Act
        AgreementDto agreementDto = agreementMapper.entityToDto(agreement);

        // Assert
        assertEquals(agreement.getId(), agreementDto.getId());
    }
}
