package com.test.nutri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.IngredientView;

public interface IngredientViewRepository extends JpaRepository<IngredientView, Integer> {
    Optional<IngredientView> findByIngredientName(String ingredientName);
}