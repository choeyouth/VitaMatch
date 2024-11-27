package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.model.NewsDTO;
import com.test.nutri.service.NewsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NewsController {

	private final NewsService newsService;

	@GetMapping("/news")
	public String news(Model model, @RequestParam(defaultValue = "1", name = "page") Integer page) {
		int count = newsService.getCount();
		double maxListSize = 6;
		double maxPageSize = 10;
		int pageCount = (int) Math.ceil(count / maxListSize);
		int offset = (int) ((page - 1) * maxListSize);

		List<NewsDTO> list = newsService.getNewsList(offset, (int) maxListSize);

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

		sb.append(String.format("<a href=\"/news?page=%d\">&lt;</a>", beforePage));

		for (int i = firstPage; i <= pageCount && i < firstPage + maxPageSize; i++) {
			if (page == i) {
				sb.append(String.format("<a href=\"/news?page=%d\" class=\"active\">%d</a>", i, i));
			} else {
				sb.append(String.format("<a href=\"/news?page=%d\">%d</a>", i, i));
			}
		}

		//퍼가요~♥
		
		sb.append(String.format("<a href=\"/news?page=%d\">&gt;</a>", nextPage));

		model.addAttribute("list", list);
		model.addAttribute("page", sb.toString());

		return "page/news";
	}
}
