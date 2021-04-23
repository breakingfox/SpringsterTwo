package com.example.SpringsterTwo.service.collection;

import com.example.SpringsterTwo.dto.CollectionDto;
import com.example.SpringsterTwo.entity.Collection;
import com.example.SpringsterTwo.repository.CollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionRepository collectionRepository;
    CollectionConverter collectionConverter;

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
}
