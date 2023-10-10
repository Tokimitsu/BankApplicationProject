package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.AgreementMapper;
import com.example.bankapppro.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService agreementService;


    @GetMapping("/{id}")
    public AgreementDto getAgreementById(@PathVariable Long id) {
        return agreementService.getAgreementById(id);
    }

    //TODO findAgreementsWhereClientIdIs
//    @PostMapping
//    public AgreementDto createAgreement(@RequestBody Agreement agreement) {
//       return agreementService.createAgreement(agreement);
//    }
//
//    @PutMapping("/{id}")
//    public AgreementDto updateAgreement(@PathVariable Long id, @RequestBody Agreement agreement) throws EntityNotFoundException {
//       return agreementService.updateAgreement(id, agreement);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAgreement(@PathVariable Long id) {
//        agreementService.deleteAgreement(id);
//    }

//    @GetMapping("/all")
//    public List<AgreementDto> getAllAgreements() {
//        return agreementService.getAllAgreements();
//    }
}