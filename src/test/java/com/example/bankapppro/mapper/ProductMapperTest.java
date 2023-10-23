package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    public void setUp() {
        productMapper = Mappers.getMapper(ProductMapper.class);
    }

    @Test
    public void testEntityListToDtoList() {
        // Arrange
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");

        List<Product> productList = Arrays.asList(product1, product2);

        // Act
        List<ProductDto> productDtoList = productMapper.entityListToDtoList(productList);

        // Assert
        assertEquals(productList.size(), productDtoList.size());
        assertEquals(productList.get(0).getId(), productDtoList.get(0).getId());
        assertEquals(productList.get(0).getName(), productDtoList.get(0).getName());
    }
}
