package com.example.SpringsterTwo.service.collection;

import com.example.SpringsterTwo.dto.CollectionDto;

import java.util.List;

public interface CollectionService {
     CollectionDto findRecipeByCollectionId(Long id);
     List<CollectionDto> findColByUserId(Long id);
}
