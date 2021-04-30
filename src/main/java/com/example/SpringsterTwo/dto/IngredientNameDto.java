package com.example.SpringsterTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientNameDto {

    private Long id;
    private Long recipe_id;
    private Long product_id;
    private String productName;
    private String unit;
    private Long quantity;
}
