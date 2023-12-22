package com.example.bankapppro.mapper;

import com.example.bankapppro.dto.ProductDto;
import com.example.bankapppro.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDto> entityListToDtoList(List<Product> products);

    Product dtoToEntity(ProductDto productDto);
}
