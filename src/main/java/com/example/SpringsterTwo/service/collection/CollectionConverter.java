package com.example.SpringsterTwo.service.collection;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.dto.RecipeFullDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.Recipe;
import com.example.SpringsterTwo.repository.CollectionRepository;
import com.example.SpringsterTwo.service.recipe.RecipeConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.rmi.server.LogStream.log;

@Slf4j
@Component
@AllArgsConstructor
public class CollectionConverter {

    private final CollectionRepository collectionRepository;
    private final RecipeConverter recipeConverter;
//
//    public Collection toCollectionfromCollectionDto(CollectionDto collectionDto) {
//        return Collection.builder().id(collectionDto.g)
//                .build();
//    }

    public CollectionDto fromCollection(Collection collection) {
        return CollectionDto
                .builder()
                .collectionName(collection.getName())
                .recipeFullDtos(collectionRepository.findColById(collection.getId()).stream().map(recipeConverter::fromRecipe).collect(Collectors.toList()))
                .build();
    }
}
