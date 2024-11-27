package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	@GetMapping("/review")
	public String review(Model model) {
		
		return "page/review";
	}
	
	@GetMapping("/viewReview")
	public String viewtReview(Model model) {
		
		return "page/viewReview";
	}
	
	@GetMapping("/addReview")
	public String addReview(Model model) {
		
		return "page/addReview";
	}
	
	@GetMapping("/editReview")
	public String editReview(Model model) {
		
		return "page/editReview";
	}
	
	@GetMapping("/delReview")
	public String deltReview(Model model) {
		
		return "page/delReview";
	}
		


}
