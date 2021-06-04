package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.RecipeRepository;
import com.example.SpringsterTwo.repository.UserRepository;
import com.example.SpringsterTwo.service.ImgBBConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeFullDto implements Serializable {
    private Long id;
    private String name;
    private Integer time;
    private String type;
    private String instruction;
    private Boolean is_private;
    private Long author_id;
    private String username;
    private String photo;
    private List<IngredientNameDto> ingredientDtoList;

    //в рецепт не передаем айди для автоинкремента
    public Recipe toRecipe() throws Exception {
        ImgBBConverter converter = new ImgBBConverter();
        return Recipe.builder()
                .name(name)
                .authorId(author_id)
                .instruction(instruction)
                .is_private(is_private)
                .time(time)
                .type(type)
                .photo(converter.writeToStore(photo.getBytes()))
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
               // .username(userRepository.findById(recipe.getAuthorId()).get().getUsername())
                //уберем для теста
                .photo(recipe.getPhoto())
                .type(recipe.getType())
                .build();
    }
}
