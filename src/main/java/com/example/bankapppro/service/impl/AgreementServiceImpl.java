package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.mapper.AgreementMapper;
import com.example.bankapppro.repository.AgreementRepository;
import com.example.bankapppro.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;

    @Override
    public AgreementDto getAgreementById(Long id) {
        return agreementRepository.findById(id)
                .map(agreementMapper::entityToDto).orElse(null);
    }
}
