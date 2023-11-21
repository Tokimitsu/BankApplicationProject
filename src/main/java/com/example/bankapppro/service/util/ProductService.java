package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDto> getAllActiveProducts();

    List<ProductDto> findAllProductsWhereAgreementsQuantityMoreThan(Integer quantity);

}