package com.test.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.admin.dto.ReviewDTO;
import com.test.admin.service.ReviewService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	
	@GetMapping("/review")
	public String getReview(Model model, @RequestParam(value = "seq", required = false) Long seq, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		if (seq != null) {
			
			ReviewDTO review = reviewService.get(seq);
			
			model.addAttribute("review", review);
			
			return "page/reviewDetail";
		} else {
			int count = reviewService.getCount();
			double maxListSize = 6;
			double maxPageSize = 10;
			int pageCount = (int) Math.ceil(count / maxListSize);
			int offset = (int) ((page - 1) * maxListSize);

			List<ReviewDTO> list = reviewService.getReviewList(offset, (int) maxListSize);

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

			sb.append(String.format("<a href=\"/review?page=%d\">&lt;</a>", beforePage));

			for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
				if (page == i) {
					sb.append(String.format("<a href=\"/review?page=%d\" class=\"active\">%d</a>", i, i));
				} else {
					sb.append(String.format("<a href=\"/review?page=%d\">%d</a>", i, i));
				}
			}
			
			sb.append(String.format("<a href=\"/review?page=%d\">&gt;</a>", nextPage));

			model.addAttribute("list", list);
			model.addAttribute("page", sb.toString());
			
			return "page/review";
		}
	}
	
}
