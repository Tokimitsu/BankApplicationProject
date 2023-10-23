package com.example.bankapppro.dto;

import com.example.bankapppro.entity.ProductStatus;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private ProductStatus status;
    private Integer currencyCode;
    private Integer minInterestRate;
    private Long maxOfferLimit;
}
