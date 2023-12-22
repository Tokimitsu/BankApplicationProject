package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.mapper.ProductMapper;
import com.example.bankapppro.service.util.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAllActiveProducts_shouldReturnActiveProducts() {
        // Arrange
        ProductService productService = Mockito.mock(ProductService.class);
        ProductController productController = new ProductController(productService);

        // Mock the expected response from the service
        ProductDto productDto1 = new ProductDto();
        ProductDto productDto2 = new ProductDto();
        List<ProductDto> expectedActiveProductDto = Arrays.asList(productDto1, productDto2);
        when(productService.getAllActiveProducts()).thenReturn(expectedActiveProductDto);

        // Act
        List<ProductDto> response = productController.getAllActiveProducts();

        // Assert
        assertEquals(expectedActiveProductDto, response);
    }
    @Test
    void findAllProductsWhereAgreementsQuantityMoreThan_shouldReturnFilteredProducts() {
        // Arrange
        int minQuantity = 3;
        List<ProductDto> fakeProducts = Arrays.asList(
                new ProductDto(),
                new ProductDto());

        when(productService.findAllProductsWhereAgreementsQuantityMoreThan(anyInt())).thenReturn(fakeProducts);
        // Act
        List<ProductDto> responseList = productController.findAllProductsWhereAgreementsQuantityMoreThan(minQuantity);
        ResponseEntity<List<ProductDto>> responseEntity = new ResponseEntity<>(responseList, HttpStatus.OK);

        // Assert
        assertEquals(ResponseEntity.ok(fakeProducts), responseEntity);
    }

}

