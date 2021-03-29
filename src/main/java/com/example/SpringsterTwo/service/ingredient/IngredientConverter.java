package com.example.SpringsterTwo.service.ingredient;

import com.example.SpringsterTwo.dto.IngredientDto;
import com.example.SpringsterTwo.entity.Ingredient;
import com.example.SpringsterTwo.entity.Recipe;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter {
    public Ingredient fromIngredientDtoToIngredient(IngredientDto ingredientDto) {
        return Ingredient.builder()
                .id(ingredientDto.getId())
                .product_id(ingredientDto.getProduct_id())
                .quantity(ingredientDto.getQuantity())
                .recipe_id(ingredientDto.getRecipe_id())
                .unit(ingredientDto.getUnit())
                .build();
    }

    public IngredientDto fromIngredientToIngredientDto(Ingredient ingredient) {
        return IngredientDto.builder()
                .id(ingredient.getId())
                .product_id(ingredient.getProduct_id())
                .quantity(ingredient.getQuantity())
                .recipe_id(ingredient.getRecipe_id())
                .unit(ingredient.getUnit())
                .build();
    }
}
