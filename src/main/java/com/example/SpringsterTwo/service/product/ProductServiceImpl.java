package com.example.SpringsterTwo.service.product;

import com.example.SpringsterTwo.dto.ProductDto;
import com.example.SpringsterTwo.entity.Product;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDto saveProduct(ProductDto productDto) throws ValidationException {
        validateProductDto(productDto);
        Product testProduct = productConverter.fromProductDtoToProduct(productDto);

        Product savedProduct = productRepository.saveAndFlush(testProduct);
        return productConverter.fromProductToProductDto(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> findByName(String name) {
        List<Product> product = productRepository.findByNameIgnoreCase(name);
        if (product != null)
            return productRepository.findByNameIgnoreCase(name).stream().map(productConverter::fromProductToProductDto).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productConverter::fromProductToProductDto).collect(Collectors.toList());
    }

    private void validateProductDto(ProductDto productDto) throws ValidationException {
        if (isNull(productDto)) {
            throw new ValidationException("Product is null");
        }
        if (isNull(productDto.getName()) || productDto.getName().isEmpty()) {
            throw new ValidationException("Product name is empty");
        }
    }
}
