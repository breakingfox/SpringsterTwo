package com.example.SpringsterTwo.service.collection;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.entity.CollectionRel;
import com.example.SpringsterTwo.repository.CollectionRelRepository;
import com.example.SpringsterTwo.repository.CollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository collectionRepository;
    private final CollectionConverter collectionConverter;
    private final CollectionRelRepository collectionRelRepository;

    @Override
    public CollectionDto findRecipeByCollectionId(Long id) {
        return collectionConverter.fromCollection(collectionRepository.findById(id).get());
    }

    @Override
    public List<CollectionDto> findColByUserId(Long id) {
        List<Long> list = collectionRepository.findAllByUserId(id).stream().map(Collection::getId).collect(Collectors.toList());
        List<CollectionDto> collectionDtos = new LinkedList<CollectionDto>();
        for (Long i : list) {
            collectionDtos.add(findRecipeByCollectionId(i));
        }
        return collectionDtos;
    }

    @Override
    public Collection saveCollection(Collection collection) {
        Collection savedCollection = collectionRepository.saveAndFlush(collection);
        return savedCollection;
    }

    @Override
    public CollectionRel addRecipe(CollectionRel collectionRel) {
        collectionRel.getId();
        CollectionRel savedCollection = collectionRelRepository.saveAndFlush(collectionRel);
        return savedCollection;
    }

    @Override
    public void deleteFromCOllectionByRecipeId(Long col_id, Long recipe_id) {
        collectionRelRepository.deleteFromCollectionByRecipeId(col_id, recipe_id);
    }
}
