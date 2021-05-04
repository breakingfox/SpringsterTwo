package com.example.SpringsterTwo.service.recipe;

import com.example.SpringsterTwo.dto.IngredientNameDto;
import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.IngredientRepository;
import com.example.SpringsterTwo.repository.RecipeRepository;
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
    private final RecipeRepository recipeRepository;

    public Recipe fromRecipeDtoToRecipe(RecipeDto recipeDto) {
        return Recipe.builder().id(recipeDto.getId())
                .name(recipeDto.getName())
                .authorId(recipeDto.getAuthor_id())
                .instruction(recipeDto.getInstruction())
                .is_private(recipeDto.getIs_private())
                .time(recipeDto.getTime())
                .type(recipeDto.getType())
                .build();
    }

    public RecipeFullDto fromRecipe(Recipe recipe) {
        return RecipeFullDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .ingredientDtoList(ingredientRepository.findByRecipeId(recipe.getId()).stream().map(ingredientConverter::toIngredientNameDto).collect(Collectors.toList()))
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                //для теста пока уберем
                .photo(recipeRepository.findById(recipe.getId()).get().getPhoto())
                .type(recipe.getType())
                .build();
    }

    public RecipeFullDto fromRecipeToRecipeFullDto(Recipe recipe, List<IngredientNameDto> ingredientDtos) {
        return RecipeFullDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .ingredientDtoList(ingredientDtos)
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                //уберем для теста
                .photo(recipeRepository.findById(recipe.getId()).get().getPhoto())
                .type(recipe.getType())
                .build();
    }

    public RecipeDto fromRecipeToRecipeDto(Recipe recipe) {
        return RecipeDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                .photo(recipe.getPhoto())
                .type(recipe.getType())
                .build();
    }
}
