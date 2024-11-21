package com.test.nutri.service;

import org.springframework.stereotype.Service;

import com.test.nutri.repository.NewsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsRepository newsRepository;
}
