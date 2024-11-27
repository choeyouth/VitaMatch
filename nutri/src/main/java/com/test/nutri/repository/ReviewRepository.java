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
	
	public List<VwReview> findAllPagenation(int offset, int limit) {
		
		//페이징
		return jpaQueryFactory
					.selectFrom(vwReview)
					.offset(offset)	//offset: 몇번째부터 가져와라
					.limit(limit)	//limit: 몇개까지 가져와라
					.fetch();
	}

	public int count() {
		
		return (int)jpaQueryFactory
					.selectFrom(vwReview)
					.fetchCount();
	}

	public int countBySearch(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

}	
	
