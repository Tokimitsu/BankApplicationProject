package com.example.bankapppro.service.util;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto getProductById(Long id);

    ProductDto createProduct(Product product);

    List<ProductDto> getAllProducts();

    void deleteProduct(Long id) throws EntityNotFoundException;

    ProductDto updateProduct(Long id, Product product) throws EntityNotFoundException;
}
