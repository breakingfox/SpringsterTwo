package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.Recipe;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {
    private Long id;
    private String name;
    private Integer time;
    private Integer ingredient_id;
    private String type;
    private String instruction;
    private Boolean is_private;
    private Long author_id;

    public Recipe toRecipe() {
        return Recipe.builder().id(id)
                .name(name)
                .author_id(author_id)
                .ingredient_id(ingredient_id)
                .instruction(instruction)
                .is_private(is_private)
                .time(time)
                .type(type)
                .build();
    }

    public RecipeDto fromRecipe(Recipe recipe) {
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
