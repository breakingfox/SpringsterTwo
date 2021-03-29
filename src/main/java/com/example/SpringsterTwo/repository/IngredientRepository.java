package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    //List<Ingredient> findByRecipe_id(Long recipe_id);
}
