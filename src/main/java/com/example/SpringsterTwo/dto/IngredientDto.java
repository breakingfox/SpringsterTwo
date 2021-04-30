package com.example.SpringsterTwo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDto {
    private Long id;
    private Long recipe_id;
    private Long product_id;
    private String unit;
    private Long quantity;
}
