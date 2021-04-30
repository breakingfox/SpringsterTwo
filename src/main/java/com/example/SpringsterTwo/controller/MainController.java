package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.CollectionRel;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.service.collection.CollectionService;
import com.example.SpringsterTwo.service.recipe.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Log
public class MainController {
    private final RecipeService recipeService;
    private final CollectionService collectionService;
    //вывод по 9 рецептов
    @GetMapping("/listOfRecipes")
    public List<RecipeFullDto> listOfRecipes() {
        log.info("Handling find 9 recipes request");
        return recipeService.findByIdAfter(0L);
    }

    @GetMapping("/listOfRecipes/{id}")
    public List<RecipeFullDto> listOfRecipesNum(@PathVariable Long id) {
        log.info("Handling find 9 recipes request");
        return recipeService.findByIdAfter(id);
    }
    //сохранение полного рецепта
    @PostMapping("/saveRecipe")
    public RecipeFullDto saveRecipe(@RequestBody RecipeFullDto recipeFullDto) throws ValidationException {
        log.info("Handling saving full recipe: " + recipeFullDto);
        return recipeService.saveRecipeFull(recipeFullDto);
    }
    @PostMapping("/addCollection")
    public Collection saveCollection(@RequestBody Collection collection) throws ValidationException {
        log.info("Handling saving full recipe: " + collection);
        return collectionService.saveCollection(collection);
    }

    //сохранение рецепта в коллекцию
    @PostMapping("/addRecipe")
    public CollectionRel addRecipe(@RequestBody CollectionRel collectionRel) throws ValidationException {
        log.info("Handling saving full recipe: " + collectionRel);
        return collectionService.addRecipe(collectionRel);
    }

}
