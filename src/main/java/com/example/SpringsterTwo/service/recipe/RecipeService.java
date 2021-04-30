package com.example.SpringsterTwo.service.recipe;

import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.exception.ValidationException;

import java.util.List;

public interface RecipeService {
    RecipeDto saveRecipe(RecipeDto recipeDto) throws ValidationException;

    void deleteRecipe(Long id);

    List<RecipeDto> findByName(String name);

    RecipeFullDto fullInfoById(Long id);

    RecipeFullDto saveRecipeFull(RecipeFullDto recipeFullDto) throws ValidationException;


    List<RecipeDto> findAll();

    List<RecipeFullDto> findByUserId(Long id);

    List<RecipeFullDto> findByIdAfter(Long id);
}
