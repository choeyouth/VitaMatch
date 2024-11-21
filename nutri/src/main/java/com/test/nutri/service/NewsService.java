package com.test.nutri.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.nutri.entity.News;
import com.test.nutri.repository.NewsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsRepository newsRepository;

	public List<News> getNewsList(Integer page) {
		
		return null;
	}
	
}
