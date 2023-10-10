package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.AgreementMapper;
import com.example.bankapppro.repository.AgreementRepository;
import com.example.bankapppro.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;


    // Not realised yet

    @Override
    public List<AgreementDto> getAllAgreements() {
        List<Agreement> agreements = (List<Agreement>) agreementRepository.findAll();
        return agreementMapper.entityListToDTOList(agreements);
    }

    @Override
    public AgreementDto getAgreementById(Long id) {
        return agreementRepository.findById(id)
                .map(agreementMapper::entityToDto).orElse(null);
    }

    @Override
    public AgreementDto createAgreement(Agreement agreement) {
        agreementRepository.save(agreement);
        return agreementMapper.entityToDto(agreement);
    }

    @Override
    public AgreementDto updateAgreement(Long id, Agreement agreement) throws EntityNotFoundException {
        Agreement updatedAgreement = agreementRepository.findById(id).orElse(null);
        if (updatedAgreement == null) {
            throw new EntityNotFoundException();
        }
        updatedAgreement.setProduct(agreement.getProduct());
        updatedAgreement.setStatus(agreement.getStatus());
        agreementRepository.save(updatedAgreement);
        return agreementMapper.entityToDto(updatedAgreement);
    }

    @Override
    public void deleteAgreement(Long id) {
        agreementRepository.deleteById(id);
    }
}
