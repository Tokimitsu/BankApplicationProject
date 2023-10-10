package com.example.bankapppro.controller;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import com.example.bankapppro.exception.EntityNotFoundException;
import com.example.bankapppro.mapper.ProductMapper;
import com.example.bankapppro.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


//    @GetMapping("/{id}")
//    public ProductDto getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
//
//    @PostMapping
//    public ProductDto createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public ProductDto updateProduct(@PathVariable Long id, @RequestBody Product product) throws EntityNotFoundException {
//        return productService.updateProduct(id, product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) throws EntityNotFoundException {
//        productService.deleteProduct(id);
//    }
//
//    @GetMapping("/all")
//    public List<ProductDto> getAllProducts() {
//        return productService.getAllProducts();
//    }
}