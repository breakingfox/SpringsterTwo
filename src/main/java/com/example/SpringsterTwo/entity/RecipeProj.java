package com.example.SpringsterTwo.entity;

import lombok.Getter;

import java.io.Serializable;

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
