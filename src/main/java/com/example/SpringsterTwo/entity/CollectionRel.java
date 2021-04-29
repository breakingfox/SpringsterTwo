package com.example.SpringsterTwo.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "collection_rel")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollectionRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "recipe_id")
    private Long recipeId;
    @Column(name = "collection_id")
    private Long collectionId;

}
