package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto entityToDto(Product product);

    Product dtoToEntity(ProductDto productDTO);

    List<ProductDto> entityListToDtoList(List<Product> products);
}
