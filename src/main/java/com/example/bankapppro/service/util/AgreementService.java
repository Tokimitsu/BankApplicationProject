package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgreementService {
    AgreementDto getAgreementById(Long id);

    AgreementDto createAgreement(Agreement agreement);

    AgreementDto updateAgreement(Long id, Agreement agreement) throws EntityNotFoundException;

    void deleteAgreement(Long id);
    List<AgreementDto> getAllAgreements();
}
