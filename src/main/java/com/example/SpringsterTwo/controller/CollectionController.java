package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.service.collection.CollectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/collection")
@AllArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;

    @GetMapping("/find/{id}")
    public CollectionDto findCollection(@PathVariable Long id) {
        return  collectionService.findRecipeByCollectionId(id);
    }
    @GetMapping("/findUserCol/{id}")
    public List<CollectionDto> findColByUserId(@PathVariable Long id) {
        return  collectionService.findColByUserId(id);
    }
}
