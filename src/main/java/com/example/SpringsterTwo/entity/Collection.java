package com.example.SpringsterTwo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "collection")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column
    private String name;
    @Column(name = "user_id")
    private Long userId;

}
