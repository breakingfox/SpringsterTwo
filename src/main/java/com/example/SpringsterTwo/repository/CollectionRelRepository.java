package com.example.SpringsterTwo.repository;

import com.example.SpringsterTwo.entity.CollectionRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CollectionRelRepository extends JpaRepository<CollectionRel, Long> {
    @Modifying
    @Transactional
    @Query("delete from CollectionRel where collectionId=?1")
    void deleteByCollectionId(Long id);

    @Modifying
    @Transactional
    @Query("delete from CollectionRel where  recipeId=?1")
    void deleteByRecipeId(Long recipe_id);


    @Modifying
    @Transactional
    @Query("delete from CollectionRel where collectionId=?1 and recipeId=?2")
    void deleteFromCollectionByRecipeId(Long collection_id, Long recipe_id);

}
