package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.service.util.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/active")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Get all active products")
    public List<ProductDto> getAllActiveProducts() {
        return productService.getAllActiveProducts();
    }
    @GetMapping("/{quantity}")
    @PreAuthorize("hasAuthority('user:write')")
    @Tag(name = "Get all products where agreements quantity more than")
    public List<ProductDto> findAllProductsWhereAgreementsQuantityMoreThan
            (@PathVariable("quantity") Integer quantity){

        return productService.findAllProductsWhereAgreementsQuantityMoreThan(quantity);
    }
}