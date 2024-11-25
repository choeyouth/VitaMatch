package com.test.nutri.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.nutri.entity.VwReview;
import com.test.nutri.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewRepository reviewRepository;
	
	@GetMapping("/review")
	public String review(Model model) {
		
		//전체리스트 가져오기
		List<VwReview> list = reviewRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "page/review";
	}
	
	@GetMapping("/viewReview")
	public String viewReview(Model model) {
		
		/* Optional <VwReview> vwReview = reviewRepository.findReviewBySeq(); */
		
	
		
		
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
