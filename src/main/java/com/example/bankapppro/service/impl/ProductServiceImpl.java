package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.entity.ProductStatus;
import com.example.bankapppro.mapper.ProductMapper;
import com.example.bankapppro.repository.ProductRepository;
import com.example.bankapppro.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllActiveProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return productMapper.entityListToDtoList(products.stream()
                .filter(p -> p.getStatus().equals(ProductStatus.ACTIVE))
                .toList());
    }

    @Override
    public List<ProductDto> findAllProductsWhereAgreementsQuantityMoreThan(Integer quantity) {
        List<Product> products = (List<Product>) productRepository.findAll();
        return productMapper.entityListToDtoList(products.stream()
                .filter(p -> p.getAgreements().size() > quantity)
                .toList());
    }
}