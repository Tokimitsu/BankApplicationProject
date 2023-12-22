package com.example.bankapppro.controller;

import com.example.bankapppro.dto.AgreementDto;
import com.example.bankapppro.service.util.AgreementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService agreementService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    @Tag(name = "Get Agreement by Id")
    public ResponseEntity<AgreementDto> getAgreementById(@PathVariable Long id) {
        AgreementDto agreementDto = agreementService.getAgreementById(id);
        return (agreementDto != null) ? ResponseEntity.ok(agreementDto) : ResponseEntity.notFound().build();
    }
}