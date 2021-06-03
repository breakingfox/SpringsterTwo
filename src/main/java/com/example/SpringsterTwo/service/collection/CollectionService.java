package com.example.SpringsterTwo.service.collection;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.CollectionRel;

import java.util.List;

public interface CollectionService {
     CollectionDto findRecipeByCollectionId(Long id);
     List<CollectionDto> findColByUserId(Long id);
     Collection saveCollection(Collection collection);
     CollectionRel addRecipe(CollectionRel collectionRel);
     void deleteFromCOllectionByRecipeId(Long col_id, Long recipe_id);
}
