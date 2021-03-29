package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.IngredientDto;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.service.ingredient.IngredientService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@AllArgsConstructor
@Log
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping("/save")
    public IngredientDto saveIngredient(@RequestBody IngredientDto ingredientDto) throws ValidationException {
        log.info("Handling save ingredient: " + ingredientDto);
        return ingredientService.saveIngredient(ingredientDto);
    }

    @GetMapping("/findAll")
    public List<IngredientDto> findAllUsers() {
        log.info("Handling find all ingredients request");
        return ingredientService.findAll();
    }

//    @GetMapping("/findByRecipe_id")
//    public List<IngredientDto> findByName(@RequestParam Long recipe_id) {
//        log.info("Handling find by name of the ingredient request: " + recipe_id);
//        return ingredientService.findByRecipe_id(recipe_id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        log.info("Handling delete ingredient request: " + id);
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }
}
