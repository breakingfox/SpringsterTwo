package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.RecipeDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.dto.RecipeFullDtoPhoto;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.repository.RecipeRepository;
import com.example.SpringsterTwo.service.recipe.RecipeConverter;
import com.example.SpringsterTwo.service.recipe.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
@Log
public class RecipeController {
    @Autowired
    private final RecipeService recipeService;
    private final RecipeRepository repository;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:8080/")
    public RecipeDto saveRecipe(@RequestBody RecipeDto recipeDto) throws ValidationException {
        log.info("Handling save recipe: " + recipeDto);
        return recipeService.saveRecipe(recipeDto);
    }

    //вывод по 9 рецептов
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/listOfRecipes")
    public List<RecipeFullDto> listOfRecipes() {
        log.info("Handling find 9 recipes request");
        return recipeService.findByIdAfter(0L);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/listOfRecipes/{id}")
    public List<RecipeFullDto> listOfRecipesNum(@PathVariable Long id) {
        log.info("Handling find 9 recipes request");
        return recipeService.findByIdAfter(id);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findAll")
    public List<RecipeDto> findAllUsers() {
        log.info("Handling find all recipes request");
        return recipeService.findAll();
    }

    //2 одинаковых метода с разными адресами
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/fullInfo/{id}")
    public RecipeFullDto fullInfoById(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.fullInfoById(id);
    }

    //сохранение полного рецепта
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/saveFull")
    public RecipeFullDto saveRecipe(@ModelAttribute RecipeFullDtoPhoto recipeFullDtoPhoto) throws Exception {
        log.info("Handling saving full recipe: " + recipeFullDtoPhoto);

        return recipeService.saveRecipeFull(recipeFullDtoPhoto);
    }

    //кастомные рецепты пользователя
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/fullInfoByUser/{id}")
    public List<RecipeFullDto> fullInfoByUserId(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.findByUserId(id);
    }

    //просто инфа старой версии
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/info/{id}")
    public RecipeFullDto infoById(@PathVariable Long id) {
        log.info("Handling full info about recipe request");
        return recipeService.fullInfoById(id);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findByName")
    public List<RecipeDto> findByName(@RequestParam String name) {
        log.info("Handling find by name of the recipe request: " + name);
        return recipeService.findByName(name);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        log.info("Handling delete recipe request: " + id);
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }
}
