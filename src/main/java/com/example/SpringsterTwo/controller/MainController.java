package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.dto.RecipeFullDtoPhoto;
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
    //кастомные рецепты пользователя
    @GetMapping("/fullInfoByUser/{id}")
    public List<RecipeFullDto> fullInfoByUserId(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.findByUserId(id);
    }

    @GetMapping("/collection/{id}")
    public CollectionDto findCollection(@PathVariable Long id) {
        return collectionService.findRecipeByCollectionId(id);
    }

    @GetMapping("/findUserCol/{id}")
    public List<CollectionDto> findColByUserId(@PathVariable Long id) {
        return collectionService.findColByUserId(id);
    }
    @GetMapping("/listOfRecipes/{id}")
    public List<RecipeFullDto> listOfRecipesNum(@PathVariable Long id) {
        log.info("Handling find 9 recipes request");
        return recipeService.findByIdAfter(id);
    }
    //сохранение полного рецепта
    @PostMapping("/saveRecipe")
    public RecipeFullDto saveRecipe(@RequestBody RecipeFullDtoPhoto recipeFullDtoPhoto) throws Exception {
        log.info("Handling saving full recipe: " + recipeFullDtoPhoto);
        return recipeService.saveRecipeFull(recipeFullDtoPhoto);
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
    //2 одинаковых метода с разными адресами
    @GetMapping("/recipe/{id}")
    public RecipeFullDto fullInfoById(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.fullInfoById(id);
    }
}
