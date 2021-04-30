package com.example.SpringsterTwo.service.ingredient;

import com.example.SpringsterTwo.dto.IngredientDto;
import com.example.SpringsterTwo.exception.ValidationException;

import java.util.List;

public interface IngredientService {
    IngredientDto saveIngredient(IngredientDto ingredientDto) throws ValidationException;

    void deleteIngredient(Long id);

    List<IngredientDto> findByRecipe_id(Long recipe_id);

    List<IngredientDto> findAll();
}
