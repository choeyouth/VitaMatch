package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	@GetMapping("/ingredient")
	public String ingredient(Model model) {
				
		return "page/ingredient";
	}
	
	@GetMapping("/health")
	public String map(Model model) {
		
		return "page/health";
	}
}
