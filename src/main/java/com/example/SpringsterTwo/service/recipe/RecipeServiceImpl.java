package com.example.SpringsterTwo.service.recipe;


import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeConverter recipeConverter;

    @Override
    public RecipeDto saveRecipe(RecipeDto recipeDto) throws ValidationException {
        validateRecipeDto(recipeDto);
        Recipe testRecipe = recipeDto.toRecipe();

        Recipe savedRecipe = recipeRepository.saveAndFlush(testRecipe);
        return new RecipeDto().fromRecipe(savedRecipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<RecipeDto> findByName(String name) {
        List<Recipe> recipe = recipeRepository.findByNameIgnoreCase(name);
        if (recipe != null)
            return recipeRepository.findByNameIgnoreCase(name).stream().map(recipeConverter::fromRecipeToRecipeDto).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<RecipeDto> findAll() {
        return recipeRepository.findAll().stream().map(recipeConverter::fromRecipeToRecipeDto).collect(Collectors.toList());
    }

    private void validateRecipeDto(RecipeDto recipeDto) throws ValidationException {
        if (isNull(recipeDto)) {
            throw new ValidationException("Recipe is null");
        }
        if (isNull(recipeDto.getName()) || recipeDto.getName().isEmpty()) {
            throw new ValidationException("Recipe name is empty");
        }
    }
}
