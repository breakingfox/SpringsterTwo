package com.example.SpringsterTwo.dto;

import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionDto {
    private String collectionName;
    private List<RecipeFullDto> recipeFullDtos;


}
