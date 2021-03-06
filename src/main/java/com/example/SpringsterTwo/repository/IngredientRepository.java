package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipe_id);
    @Modifying
    @Transactional
    void deleteByRecipeId(Long recipe_id);
}
