package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.RecipeDto;
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

    @GetMapping("/findAll")
    public List<RecipeDto> findAllUsers() {
        log.info("Handling find all recipes request");
        return recipeService.findAll();
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
