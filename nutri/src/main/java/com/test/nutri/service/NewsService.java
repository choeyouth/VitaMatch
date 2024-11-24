package com.test.nutri.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.nutri.api.NewsAPI;
import com.test.nutri.entity.News;
import com.test.nutri.model.NewsDTO;
import com.test.nutri.model.NewsListDTO;
import com.test.nutri.repository.NewsQueryDSLRepository;
import com.test.nutri.repository.NewsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {

	private final NewsAPI newsAPI;
	private final NewsRepository newsRepository;
	private final NewsQueryDSLRepository newsQueryDSLRepository;

	public List<NewsDTO> getNewsList(Integer page) {

//		최신 뉴스부터 2024년 11월 뉴스까지 DB에 저장
		if (newsRepository.count() > 0) {
//			updateLatestNews();
		} else {
//			insertAllNews();
		}

		return newsQueryDSLRepository.findAllPagenation(page).stream()
				.map(news -> 
					NewsDTO.builder()
					.title(news.getTitle())
					.originallink(news.getOriginalLink())
					.link(news.getLink())
					.description(news.getDescription())
					.pubDate(news.getRegDate())
					.build())
				.toList();
	}

	public void updateLatestNews() {

		int start = 1;
		boolean isFind = false;
		
		NewsListDTO list;
		NewsDTO news;

		while (start > 0) {
			list = newsAPI.getNewsList(start);
			
			if(newsQueryDSLRepository.countByTitleAndLinkAndRegDate(list.getItems().getLast()) == 0) {
				System.out.println("마지막꺼가 없음");
				start++;
				return;
			}

			for (int i = list.getItems().size() - 1; i >= 0; i--) {
				
//				news = list.get
				
//				News result = newsRepository.findByTitleAndLinkAndRegDate(news)
			}
		}

	}

	public void insertAllNews() {
		
		int start = 1;
		boolean isFind = false;
		LocalDateTime baseDate = LocalDateTime.of(2024, 11, 1, 0, 0);
		
		NewsListDTO list;
		NewsDTO news;

		while (start > 0) {
			list = newsAPI.getNewsList(start);

			if (list.getItems().getLast().getPubDate().compareTo(baseDate) <= 0) {
				for (int i = list.getItems().size() - 1; i >= 0; i--) {
					news = list.getItems().get(i);
					
					if(news.getPubDate().compareTo(baseDate) >= 0) {
						newsRepository.save(news.toEntity());
					}
				}
				start--;
				isFind = true;
			} else if (isFind) {
				for (int i = list.getItems().size() - 1; i >= 0; i--) {
					news = list.getItems().get(i);
					newsRepository.save(news.toEntity());
				}
				start--;
			} else {
				start++;
			}

		}
	}
}
