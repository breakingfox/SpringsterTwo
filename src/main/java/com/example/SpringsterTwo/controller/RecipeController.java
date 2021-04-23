package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.service.recipe.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
@Log
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/save")
    public RecipeDto saveRecipe(@RequestBody RecipeDto recipeDto) throws ValidationException {
        log.info("Handling save recipe: " + recipeDto);
        return recipeService.saveRecipe(recipeDto);
    }

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

    @GetMapping("/findAll")
    public List<RecipeDto> findAllUsers() {
        log.info("Handling find all recipes request");
        return recipeService.findAll();
    }

    //2 одинаковых метода с разными адресами
    @GetMapping("/fullInfo/{id}")
    public RecipeFullDto fullInfoById(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.fullInfoById(id);
    }

    //кастомные рецепты пользователя
    @GetMapping("/fullInfoByUser/{id}")
    public List<RecipeFullDto> fullInfoByUserId(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.findByUserId(id);
    }

    //просто инфа старой версии
    @GetMapping("/info/{id}")
    public RecipeFullDto infoById(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.fullInfoById(id);
    }

    @GetMapping("/findByName")
    public List<RecipeDto> findByName(@RequestParam String name) {
        log.info("Handling find by name of the recipe request: " + name);
        return recipeService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        log.info("Handling delete recipe request: " + id);
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }
}
