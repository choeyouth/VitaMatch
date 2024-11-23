package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.News;
import com.test.nutri.service.NewsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NewsController {

	private final NewsService newsService;
	
	@GetMapping("/news")
	public String news(Model model, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		List<News> list = newsService.getNewsList(page);
//		
//		model.addAttribute("list", list);
		
		return "page/news";
	}
}
