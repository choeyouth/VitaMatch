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
		
        model.addAttribute("list", categoryPage.getContent());
        model.addAttribute("totalPages", categoryPage.getTotalPages()); 
        model.addAttribute("currentPage", page);
        model.addAttribute("category", category); 
				
		return "page/ingredient";
	}
	
	@GetMapping("/health")
	public String map(Model model, @RequestParam(name="category", required = false)String category , @RequestParam(name="page", required = false, defaultValue = "0") Integer page) {
		
		Pageable pageable = PageRequest.of(page,12);
		Page<?> categoryHealth = categoryRepository.findByHealth(category, pageable);
		
		model.addAttribute("list", categoryHealth.getContent());
        model.addAttribute("totalPages", categoryHealth.getTotalPages()); 
        model.addAttribute("currentPage", page);
        model.addAttribute("category", category); 
		
		return "page/health";
	}
}
