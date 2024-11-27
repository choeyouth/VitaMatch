package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.VwReview;
import com.test.nutri.repository.ReviewQureyDSLRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewQureyDSLRepository reviewQureyDSLRepository;
   
	@GetMapping("/review")
	public String review(Model model 
							, @RequestParam(name = "keyword", required = false) String keyword
		   					, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		
		System.out.println(">>>>>>>>>" + keyword);
		
		int count = reviewQureyDSLRepository.count(keyword);
		double maxListSize = 10;
		double maxPageSize = 10;
		int pageCount = (int) Math.ceil(count / maxListSize);
		int offset = (int) ((page - 1) * maxListSize);

		List<VwReview> list = reviewQureyDSLRepository.search(offset, (int) maxPageSize, keyword);
	  
		StringBuilder sb = new StringBuilder();
	  
		int firstPage = (int) (Math.floor((page - 1) / maxPageSize) * maxPageSize + 1);
		int beforePage = (int) (firstPage - maxPageSize);
		int nextPage = (int) (firstPage + maxPageSize);
	
		if (beforePage < 0) {
	   	 	beforePage = 1;
		}
	
		if (nextPage > pageCount) {
			nextPage = pageCount;
		}
		
		if (page > 1) {
			if (keyword != null && !keyword.trim().isEmpty()) {
			     sb.append(String.format("<a href=\"/review?page=%d&keyword=%s\">&lt;</a>", beforePage, keyword));
			} else {
				 sb.append(String.format("<a href=\"/review?page=%d\">&lt;</a>", beforePage));
			}
		}
		
		for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
			if (page == i) {
				sb.append(String.format("<a href=\"/review?page=%d\" class=\"active\">%d</a>", i, i));
			} else {
				sb.append(String.format("<a href=\"/review?page=%d\">%d</a>", i, i));
			}
		}
		
		if (page < pageCount) { 
			if (keyword != null && !keyword.trim().isEmpty()) {
				sb.append(String.format("<a href=\"/review?page=%d&keyword=%s\">&gt;</a>", nextPage, keyword));
			} else {
				sb.append(String.format("<a href=\"/review?page=%d\">&gt;</a>", nextPage));
			}
		}
		
		System.out.println(list);
	    model.addAttribute("list", list);
	    model.addAttribute("page", sb.toString());
	    
	    return "page/review";
	}
   
	@GetMapping("/viewReview")
	public String viewReview(Model model, @RequestParam(value = "seq", required = false) Long seq) {
       
		if (seq == null) {
			return "redirect:/review";  
		}
       
		VwReview vwreview = reviewQureyDSLRepository.findReviewBySeq(seq);
      
		model.addAttribute("review", vwreview);
      
		return "page/viewreview";
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