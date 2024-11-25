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


	public List<News> findAllPagenation(Integer offset, Integer limit) {
		return jpaQueryFactory.selectFrom(news)
				.orderBy(news.regDate.desc())
				.offset(offset)
				.limit(limit)
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
