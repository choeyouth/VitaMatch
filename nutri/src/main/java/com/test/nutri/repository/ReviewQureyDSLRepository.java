package com.test.nutri.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.nutri.entity.QVwReview;
import com.test.nutri.entity.VwReview;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewQureyDSLRepository {
	
	private final JPAQueryFactory jpaQueryFactory;
	private final QVwReview vwReview = QVwReview.vwReview;	//Q 클래스 선언
	
	// 전체 리뷰
	public List<VwReview> findAll() {
		return jpaQueryFactory.selectFrom(vwReview).fetch();
	}
	
	// seq가 일치하는 리뷰 필터링
	public VwReview findReviewBySeq(Long seq) {
		
		return jpaQueryFactory
				.selectFrom(vwReview)
				.where(vwReview.seq.eq(seq))
				.fetchOne();
	}
	
	// 전체 리뷰 페이징
	public List<VwReview> findAllPagenation(int offset, int limit) {
		
		return jpaQueryFactory
					.selectFrom(vwReview)
					.offset(offset)	//offset: 몇번째부터 가져와라
					.limit(limit)	//limit: 몇개까지 가져와라
					.fetch();
	}

	// 전체 리뷰 개수
	public int count() {
		
		return (int)jpaQueryFactory
					.selectFrom(vwReview)
					.fetchCount();
	}
	
	// keyword 검색
	public List<VwReview> search(int offset, int limit, String keyword) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
	    if (keyword != null && !keyword.trim().isEmpty()) {
	        builder.or(vwReview.category.contains(keyword))
	               .or(vwReview.title.contains(keyword))
	               .or(vwReview.content.contains(keyword))
	               .or(vwReview.name.contains(keyword));
	    }

	    return jpaQueryFactory
	            .selectFrom(vwReview)
	            .where(builder)  
	            .offset(offset)  
	            .limit(limit)    
	            .fetch();
	}

	// keyword 검색 조건에 맞는 테이터의 개수
	public int count(String keyword) {

		BooleanBuilder builder = new BooleanBuilder();
		
	    if (keyword != null && !keyword.trim().isEmpty()) {

	    	builder.or(vwReview.category.contains(keyword))
            	   .or(vwReview.title.contains(keyword))
            	   .or(vwReview.content.contains(keyword))
                   .or(vwReview.name.contains(keyword));
	    }

	    // 검색 조건에 맞는 데이터의 개수
	    return jpaQueryFactory
	            .select(vwReview.count())
	            .from(vwReview)
	            .where(builder)  
	            .fetchOne()
	            .intValue();	// 결과를 int로 변환하여 반환
	}

	// seq가 일치하는 리뷰 삭제
	public void deleteReviewBySeq(Long seq) {

		jpaQueryFactory.delete(vwReview)
					   .where(vwReview.seq.eq(seq))
					   .execute();
		
	}

}	
	
