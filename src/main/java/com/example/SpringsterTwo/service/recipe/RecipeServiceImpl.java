package com.example.SpringsterTwo.service.recipe;


import com.example.SpringsterTwo.dto.*;
import com.example.SpringsterTwo.entity.Ingredient;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.repository.IngredientRepository;
import com.example.SpringsterTwo.repository.ProductRepository;
import com.example.SpringsterTwo.repository.RecipeRepository;
import com.example.SpringsterTwo.service.ingredient.IngredientConverter;
import com.example.SpringsterTwo.service.ingredient.IngredientService;
import com.example.SpringsterTwo.service.product.ProductConverter;
import com.example.SpringsterTwo.service.product.ProductService;
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

    private final IngredientRepository ingredientRepository;
    private final IngredientConverter ingredientConverter;
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final IngredientService ingredientService;

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
    public RecipeFullDto fullInfoById(Long id) {
        RecipeFullDto recipeFullDto = new RecipeFullDto().fromRecipe(recipeRepository.findById(id).get(), ingredientRepository.findByRecipeId(id).stream().map(ingredientConverter::toIngredientNameDto).collect(Collectors.toList()));
        return recipeFullDto;
    }


    //сохранение полного рецепта для сайта
    @Override
    public RecipeFullDto saveRecipeFull(RecipeFullDto recipeFullDto) throws ValidationException {
        List<IngredientNameDto> listIngredient = recipeFullDto.getIngredientDtoList();

        //лист дто с продуктами для сохранения
        List<ProductDto> productDtoList = listIngredient.stream().map(productConverter::fromIngredientNameDtoToProductDto).collect(Collectors.toList());

        //получили лист дто ингредиентов для сохранения
        List<IngredientDto> ingredientDtoList = listIngredient.stream().map(ingredientConverter::fromIngredientNameDtoToIngredientDto).collect(Collectors.toList());
        for (ProductDto cur : productDtoList
        ) {
            try {
                productService.saveProduct(cur);

            } catch (ValidationException e) {
                throw e;
            }
        }
        for (IngredientDto cur : ingredientDtoList
        ) {
            try {
                ingredientService.saveIngredient(cur);

            } catch (ValidationException e) {
                throw e;

            }
        }
        //   #TODO доделать сохранение
//

        Recipe testRecipe = recipeFullDto.toRecipe();
        Recipe savedRecipe = recipeRepository.saveAndFlush(testRecipe);

        return recipeConverter.fromRecipe(savedRecipe);

    }

    @Override
    public List<RecipeDto> findAll() {
        return recipeRepository.findAll().stream().map(recipeConverter::fromRecipeToRecipeDto).collect(Collectors.toList());
    }

    @Override
    public List<RecipeFullDto> findByUserId(Long id) {
        return recipeRepository.findByAuthorId(id).stream().map(recipeConverter::fromRecipe).collect(Collectors.toList());
    }

    @Override
    public List<RecipeFullDto> findByIdAfter(Long id) {
        return recipeRepository.findTop9AllByIdAfter(id).stream().map(recipeConverter::fromRecipe).collect(Collectors.toList());
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
