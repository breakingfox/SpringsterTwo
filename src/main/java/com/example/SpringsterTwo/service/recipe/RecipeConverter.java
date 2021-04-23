package com.example.SpringsterTwo.service.recipe;

import com.example.SpringsterTwo.dto.IngredientNameDto;
import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.IngredientRepository;
import com.example.SpringsterTwo.service.ingredient.IngredientConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//
@Component
@AllArgsConstructor
public class RecipeConverter {

    private final IngredientRepository ingredientRepository;
    private final IngredientConverter ingredientConverter;

    public Recipe fromRecipeDtoToRecipe(RecipeDto recipeDto) {
        return Recipe.builder().id(recipeDto.getId())
                .name(recipeDto.getName())
                .authorId(recipeDto.getAuthor_id())
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
    public RecipeFullDto fromRecipe(Recipe recipe) {
        return RecipeFullDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .ingredientDtoList(ingredientRepository.findByRecipeId(recipe.getId()).stream().map(ingredientConverter::toIngredientNameDto).collect(Collectors.toList()))
                .ingredient_id(recipe.getIngredient_id())
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                .type(recipe.getType())
                .build();
    }

    public RecipeDto fromRecipeToRecipeDto(Recipe recipe) {
        return RecipeDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .ingredient_id(recipe.getIngredient_id())
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                .type(recipe.getType())
                .build();
    }
}
