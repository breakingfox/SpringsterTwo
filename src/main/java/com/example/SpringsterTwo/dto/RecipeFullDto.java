package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeFullDto {
    private Long id;
    private String name;
    private Integer time;
    private String type;
    private String instruction;
    private Boolean is_private;
    private Long author_id;
    private List<IngredientNameDto> ingredientDtoList;
//в рецепт не передаем айди для автоинкремента
    public Recipe toRecipe() {
        return Recipe.builder()
                .name(name)
                .authorId(author_id)
                .instruction(instruction)
                .is_private(is_private)
                .time(time)
                .type(type)
                .build();
    }

    public RecipeFullDto fromRecipe(Recipe recipe, List<IngredientNameDto> ingredientDtos) {
        return RecipeFullDto.builder().id(recipe.getId())
                .name(recipe.getName())
                .author_id(recipe.getAuthorId())
                .ingredientDtoList(ingredientDtos)
                .instruction(recipe.getInstruction())
                .is_private(recipe.getIs_private())
                .time(recipe.getTime())
                .type(recipe.getType())
                .build();
    }
}
