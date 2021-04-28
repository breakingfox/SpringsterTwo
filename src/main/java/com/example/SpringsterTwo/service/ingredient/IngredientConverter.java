package com.example.SpringsterTwo.service.ingredient;

import com.example.SpringsterTwo.dto.IngredientDto;
import com.example.SpringsterTwo.dto.IngredientNameDto;
import com.example.SpringsterTwo.entity.Ingredient;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IngredientConverter {
    private final ProductRepository productRepository;

    public Ingredient fromIngredientDtoToIngredient(IngredientDto ingredientDto) {
        return Ingredient.builder()
                .id(ingredientDto.getId())
                .product_id(ingredientDto.getProduct_id())
                .quantity(ingredientDto.getQuantity())
                .recipeId(ingredientDto.getRecipe_id())
                .unit(ingredientDto.getUnit())
                .build();
    }

    public IngredientDto fromIngredientToIngredientDto(Ingredient ingredient) {
        return IngredientDto.builder()
                .id(ingredient.getId())
                .product_id(ingredient.getProduct_id())
                .quantity(ingredient.getQuantity())
                .recipe_id(ingredient.getRecipeId())
                .unit(ingredient.getUnit())
                .build();
    }

    public IngredientNameDto toIngredientNameDto(Ingredient ingredient) {
        return IngredientNameDto.builder()
                .id(ingredient.getId())
                .productName(productRepository.findById(ingredient.getProduct_id()).get().getName())
                .quantity(ingredient.getQuantity())
                .product_id(ingredient.getProduct_id())
                .recipe_id(ingredient.getRecipeId())
                .unit(ingredient.getUnit())
                .build();
    }

    public IngredientDto fromIngredientNameDtoToIngredientDto(IngredientNameDto ingredient) {
        return IngredientDto.builder()
                .id(ingredient.getId())
                .quantity(ingredient.getQuantity())
                .recipe_id(ingredient.getRecipe_id())
                .unit(ingredient.getUnit())
                .product_id(ingredient.getProduct_id())
                .build();
    }
}
