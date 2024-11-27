package com.test.nutri.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.nutri.model.IngredientViewDTO;
import com.test.nutri.service.IngredientViewService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IngredientViewController {

    private final IngredientViewService ingredientViewService;

    @GetMapping("/ingredientView")
    public String ingredientView(Model model) {
        // View에서 특정 ingredientName 조회
        Optional<IngredientViewDTO> ingredientView = ingredientViewService
                .getIngredientViewByName("마그네슘");

        // Model에 추가
        ingredientView.ifPresent(view -> model.addAttribute("ingredientView", view));

        return "page/ingredientView"; // View 반환
    }
}