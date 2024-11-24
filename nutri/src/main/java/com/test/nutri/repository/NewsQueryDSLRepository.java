package com.test.nutri.repository;

import static com.test.nutri.entity.QNews.news;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.News;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class NewsQueryDSLRepository {

	private final JPAQueryFactory jpaQueryFactory;
	

	public List<News> findAll() {
		return jpaQueryFactory.selectFrom(news).fetch();
	}
}
