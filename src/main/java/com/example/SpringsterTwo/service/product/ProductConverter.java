package com.example.SpringsterTwo.service.product;

import com.example.SpringsterTwo.dto.IngredientNameDto;
import com.example.SpringsterTwo.dto.ProductDto;
import com.example.SpringsterTwo.entity.Product;
import com.example.SpringsterTwo.repository.IngredientRepository;
import com.example.SpringsterTwo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductConverter {
    private final ProductRepository productRepository;
    public Product fromProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        return product;
    }

    public ProductDto fromProductToProductDto(Product product) {
        return ProductDto.builder().id(product.getId()).name(product.getName()).build();
    }
    public ProductDto fromIngredientNameDtoToProductDto(IngredientNameDto ingredientNameDto) {
        return ProductDto.builder().id(ingredientNameDto.getProduct_id()).name(ingredientNameDto.getProductName()).build();
    }
}
