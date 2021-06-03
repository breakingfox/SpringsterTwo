package com.example.SpringsterTwo.controller;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.CollectionRel;
import com.example.SpringsterTwo.exception.ValidationException;
import com.example.SpringsterTwo.service.collection.CollectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/collection")
@AllArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/addCollection")
    public Collection saveCollection(@RequestBody Collection collection) throws ValidationException {
        log.info("Handling saving full recipe: " + collection);
        return collectionService.saveCollection(collection);
    }

    //сохранение рецепта в коллекцию
    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/addRecipe")
    public CollectionRel addRecipe(@RequestBody CollectionRel collectionRel) throws ValidationException {
        log.info("Handling saving full recipe: " + collectionRel);
        return collectionService.addRecipe(collectionRel);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/find/{id}")
    public CollectionDto findCollection(@PathVariable Long id) {
        return collectionService.findRecipeByCollectionId(id);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/findUserCol/{id}")
    public List<CollectionDto> findColByUserId(@PathVariable Long id) {
        return collectionService.findColByUserId(id);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @DeleteMapping("/delete/{col_id}/{rec_id}")
    public ResponseEntity<Void> deleteRecipeFromCollection(@PathVariable("col_id") Long col_id,@PathVariable("rec_id") Long rec_id) {
        log.info("Handling delete recipe request: " + rec_id+" from collection "+ col_id);
        collectionService.deleteFromCOllectionByRecipeId(col_id,rec_id);
        return ResponseEntity.ok().build();
    }
}
