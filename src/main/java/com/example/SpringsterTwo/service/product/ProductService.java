package com.example.SpringsterTwo.service.product;

import com.example.SpringsterTwo.dto.ProductDto;
import com.example.SpringsterTwo.exception.ValidationException;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto) throws ValidationException;

    void deleteProduct(Long id);

    List<ProductDto> findByName(String name);

    List<ProductDto> findAll();
}
