package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Agreement;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.entity.ProductStatus;
import com.example.bankapppro.mapper.ProductMapper;
import com.example.bankapppro.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllActiveProducts_shouldReturnActiveProductDto() {
        // Arrange
        Product product1 = new Product();
        product1.setStatus(ProductStatus.ACTIVE);
        Product product2 = new Product();
        product2.setStatus(ProductStatus.INACTIVE);

        List<Product> allProducts = Arrays.asList(product1,product2);

        List<ProductDto> activeProductDto = productMapper.entityListToDtoList(allProducts);

        when(productRepository.findAll()).thenReturn(allProducts);
        when(productMapper.entityListToDtoList(allProducts.stream()
                .filter(p -> p.getStatus().equals(ProductStatus.ACTIVE))
                .toList()))
                .thenReturn(activeProductDto);

        // Act
        List<ProductDto> result = productService.getAllActiveProducts();

        // Assert
        assertEquals(activeProductDto, result);
    }

    @Test
    void findAllProductsWhereAgreementsQuantityMoreThan_shouldReturnFilteredProductDto() {
        // Arrange
        Agreement agreement1 = new Agreement();
        Agreement agreement2 = new Agreement();

        List<Agreement> sufficientQuantityList = new ArrayList<>(List.of(agreement1,agreement2));
        List<Agreement> unsufficientQuantityList = new ArrayList<>(List.of(agreement1));

        int quantity = 2;

        Product product1 = new Product();
        product1.setStatus(ProductStatus.ACTIVE);
        product1.setAgreements(sufficientQuantityList);

        Product product2 = new Product();
        product2.setStatus(ProductStatus.INACTIVE);
        product2.setAgreements(unsufficientQuantityList);

        List<Product> allProducts = Arrays.asList(product1,product2);


        List<ProductDto> filteredProductDto = productMapper.entityListToDtoList(allProducts);

        when(productRepository.findAll()).thenReturn(allProducts);
        when(productMapper.entityListToDtoList(allProducts.stream()
                .filter(p -> p.getAgreements().size() > quantity)
                .toList()))
                .thenReturn(filteredProductDto);

        // Act
        List<ProductDto> result = productService.findAllProductsWhereAgreementsQuantityMoreThan(quantity);

        // Assert
        assertEquals(filteredProductDto, result);
    }
}
