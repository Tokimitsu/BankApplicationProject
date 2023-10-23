package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AgreementService {
    AgreementDto getAgreementById(Long id);
}
