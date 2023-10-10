package com.example.bankapppro.service.impl;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.exception.EntityNotFoundException;
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
    public ProductDto getProductById(Long id) {
        return productMapper.entityToDto(productRepository.findById(id).orElse(null));
    }

    @Override
    public ProductDto createProduct(Product product) {
        productRepository.save(product);
        return productMapper.entityToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return productMapper.entityListToDtoList(products);
    }

    @Override
    public void deleteProduct(Long id) throws EntityNotFoundException {
        if (!productRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(Long id, Product product) throws EntityNotFoundException {
        Product updatedProduct = productRepository.findById(id).orElse(null);
        if (updatedProduct == null){
            throw new EntityNotFoundException();
        }
        updatedProduct.setName(product.getName());
        updatedProduct.setStatus(product.getStatus());
        updatedProduct.setCurrencyCode(product.getCurrencyCode());
        return productMapper.entityToDto(updatedProduct);
    }
}
