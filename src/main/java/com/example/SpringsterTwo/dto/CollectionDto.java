package com.example.SpringsterTwo.dto;

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
