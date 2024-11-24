package com.test.nutri.repository;

import static com.test.nutri.entity.QNews.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.News;
import com.test.nutri.model.NewsDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NewsQueryDSLRepository {

	private final JPAQueryFactory jpaQueryFactory;
	

	public List<News> findAll() {
		return jpaQueryFactory.selectFrom(news).fetch();
	}


	public List<News> findAllPagenation(Integer page) {
		int count = 6;
		
		return jpaQueryFactory.selectFrom(news)
				.offset(page)
				.limit(count)
				.fetch();
	}


	public Long countByTitleAndLinkAndRegDate(NewsDTO dto) {
		return jpaQueryFactory.select(news.count()).from(news)
				.where(news.title.eq(dto.getTitle())
						.and(news.link.eq(dto.getLink())
								.and(news.regDate.eq(dto.getPubDate()))))
				.fetchOne();
	}
}
