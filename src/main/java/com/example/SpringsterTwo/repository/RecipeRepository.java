package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByNameIgnoreCase(String name);

    List<Recipe> findByAuthorId(Long id);

    List<Recipe> findTop9AllByIdAfter(Long id);


    String findPhotoById(Long id);

}