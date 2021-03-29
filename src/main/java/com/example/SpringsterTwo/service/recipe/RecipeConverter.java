package com.example.SpringsterTwo.service.recipe;

import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.entity.Recipe;
import org.springframework.stereotype.Component;
//
@Component
public class RecipeConverter {

    public Recipe fromRecipeDtoToRecipe(RecipeDto recipeDto) {
        return Recipe.builder().id(recipeDto.getId())
                .name(recipeDto.getName())
                .author_id(recipeDto.getAuthor_id())
                .ingredient_id(recipeDto.getIngredient_id())
                .instruction(recipeDto.getInstruction())
                .is_private(recipeDto.getIs_private())
                .time(recipeDto.getTime())
                .type(recipeDto.getType())
                .build();
    }
/*
    public Recipe fromRecipeDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setTime(recipe.getTime());
        recipe.setAuthor_id(recipeDto.getAuthor_id());
        recipe.setIngredient_id(recipeDto.getIngredient_id());
        recipe.setInstruction(recipe.getInstruction());
        recipe.setType(recipe.getType());
        recipe.setIs_private(recipe.getIs_private());
        return recipe;
    }*/


    public RecipeDto fromRecipeToRecipeDto(Recipe recipe) {
        return RecipeDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthor_id())
                .ingredient_id(recipe.getIngredient_id())
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                .type(recipe.getType())
                .build();
    }
}
