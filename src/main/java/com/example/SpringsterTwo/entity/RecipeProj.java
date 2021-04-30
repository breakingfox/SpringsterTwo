package com.example.SpringsterTwo.entity;

public interface RecipeProj {
    Long getId();
    String getName();
    Integer getTime();
    Integer getIngredient_id();
    String getType();
    String getInstruction();
    Boolean getIs_private();
    Long getAuthor_id();

}
