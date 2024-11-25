package com.test.nutri.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.nutri.entity.IngredientView;
import com.test.nutri.model.IngredientViewDTO;
import com.test.nutri.repository.IngredientViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientViewService {

    private final IngredientViewRepository ingredientViewRepository;

    public Optional<IngredientViewDTO> getIngredientViewByName(String ingredientName) {
        return ingredientViewRepository.findByIngredientName(ingredientName)
                .map(IngredientView::toDTO);
    }
}