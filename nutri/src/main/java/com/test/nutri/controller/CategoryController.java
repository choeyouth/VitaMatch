package com.test.nutri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.repository.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@GetMapping("/ingredient")
	public String ingredient(Model model, @RequestParam(name="category", required = false)String category , @RequestParam(name="page", required = false, defaultValue = "0") Integer page) {
		
		Pageable pageable = PageRequest.of(page, 12);
        Page<?> categoryPage = categoryRepository.findByCategory(category, pageable);
		
        model.addAttribute("list", categoryPage.getContent()); // 현재 페이지의 데이터
        model.addAttribute("totalPages", categoryPage.getTotalPages()); // 전체 페이지 수
        model.addAttribute("currentPage", page); // 현재 페이지
        model.addAttribute("category", category); // 카테고리 정보 유지
				
		return "page/ingredient";
	}
	
	@GetMapping("/health")
	public String map(Model model) {
		
		return "page/health";
	}
}
