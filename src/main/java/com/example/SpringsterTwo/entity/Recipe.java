package com.example.SpringsterTwo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String name;
    @Column
    private Integer time;
    @Column
    private Integer ingredient_id;
    @Column
    private String type;
    @Column
    private Boolean is_private;
    @Column
    private String instruction;
    @Column(name = "author_id")
    private Long authorId;
}