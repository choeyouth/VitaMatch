package com.test.nutri.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.QVwReview;
import com.test.nutri.entity.VwReview;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {
	
	private final JPAQueryFactory jpaQueryFactory;
	private final QVwReview vwReview = QVwReview.vwReview;	//Q 클래스 선언
	
	public List<VwReview> findAll() {
		return jpaQueryFactory.selectFrom(vwReview).fetch();
	}
	
	public VwReview findReviewBySeq(Long seq) {
		
		return jpaQueryFactory
				.selectFrom(vwReview)
				.where(vwReview.seq.eq(seq))
				.fetchOne();
	}
}	
	
