package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.entity.RecipeProj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    //    @Query(value = "select * from collections",nativeQuery = true)
    @Query("select r.name from  Recipe  r")
    List<String> findAny();

    @Query("select r from CollectionRel c left join Recipe r on c.recipeId=r.id where c.collectionId=?1")
    List<Recipe> findColById(Long id);


    List<Collection> findAllByUserId(Long id);
}
