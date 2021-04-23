package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.Ingredient;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientNameDto {

    private Long id;
    private Long recipe_id;
    private String productName;
    private String unit;
    private Long quantity;
}
