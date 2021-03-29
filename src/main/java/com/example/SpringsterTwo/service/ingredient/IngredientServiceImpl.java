package com.example.SpringsterTwo.service.ingredient;

import com.example.SpringsterTwo.dto.IngredientDto;
import com.example.SpringsterTwo.entity.Ingredient;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.repository.IngredientRepository;
import com.example.SpringsterTwo.service.ingredient.IngredientConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientConverter ingredientConverter;

    @Override
    public IngredientDto saveIngredient(IngredientDto ingredientDto) throws ValidationException {
        validateIngredientDto(ingredientDto);
        Ingredient testIngredient = ingredientConverter.fromIngredientDtoToIngredient(ingredientDto);

        Ingredient savedIngredient = ingredientRepository.saveAndFlush(testIngredient);
        return ingredientConverter.fromIngredientToIngredientDto(savedIngredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
//
//    @Override
//    public List<IngredientDto> findByRecipe_id(Long recipe_id) {
//        List<Ingredient> ingredient = ingredientRepository.findByRecipe_id(recipe_id);
//        if (ingredient != null)
//            return ingredientRepository.findByRecipe_id(recipe_id).stream().map(ingredientConverter::fromIngredientToIngredientDto).collect(Collectors.toList());
//        return null;
//    }

    @Override
    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll().stream().map(ingredientConverter::fromIngredientToIngredientDto).collect(Collectors.toList());
    }

    private void validateIngredientDto(IngredientDto ingredientDto) throws ValidationException {
        if (isNull(ingredientDto)) {
            throw new ValidationException("Ingredient is null");
        }
        if (isNull(ingredientDto.getProduct_id()) || isNull(ingredientDto.getRecipe_id())) {
            throw new ValidationException("Ingredient foreign keys are empty");
        }
    }
}
