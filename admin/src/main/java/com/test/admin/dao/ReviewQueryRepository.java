package com.test.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.admin.entity.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepository {
	
	private final JPAQueryFactory jpaQueryFactory;

	public List<Review> findAllPagenation(int offset, int limit) {
//		return jpaQueryFactory.selectFrom(review)
//				.offset(offset)
//				.limit(limit)
//				.fetch();
		return null;
	}

}
