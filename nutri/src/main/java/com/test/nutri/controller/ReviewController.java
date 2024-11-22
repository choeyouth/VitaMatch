package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	@GetMapping("/reivew")
	public String review(Model model) {
		return "page/review";
	}
		


}
