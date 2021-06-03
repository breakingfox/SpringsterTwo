package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.ProductDto;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.service.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Log
public class ProductController {
    private final ProductService productService;
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/save")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) throws ValidationException {
        log.info("Handling save product: " + productDto);
        return productService.saveProduct(productDto);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findAll")
    public List<ProductDto> findAllUsers() {
        log.info("Handling find all products request");
        return productService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findByName")
    public List<ProductDto> findByName(@RequestParam String name) {
        log.info("Handling find by name of the product request: " + name);
        return productService.findByName(name);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        log.info("Handling delete product request: " + id);
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
