package com.example.bankapppro.repository;

import com.example.bankapppro.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
