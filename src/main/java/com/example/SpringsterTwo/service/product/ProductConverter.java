package com.example.SpringsterTwo.service.product;

import com.example.SpringsterTwo.dto.ProductDto;
import com.example.SpringsterTwo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product fromProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        return product;
    }

    public ProductDto fromProductToProductDto(Product product) {
        return ProductDto.builder().id(product.getId()).name(product.getName()).build();
    }
}
