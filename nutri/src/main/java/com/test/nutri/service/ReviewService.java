package com.test.nutri.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.nutri.entity.VwReview;
import com.test.nutri.repository.ReviewQureyDSLRepository;

public class ReviewService {

	private final ReviewQureyDSLRepository reviewQureyDSLRepository;
	
	public ReviewService(ReviewQureyDSLRepository reviewQureyDSLRepository) {
        this.reviewQureyDSLRepository = reviewQureyDSLRepository;
    }
	
	// 리뷰 조회
    public VwReview getReviewBySeq(Long seq) {
        return reviewQureyDSLRepository.findReviewBySeq(seq);
    }

    // 리뷰 수정
    public void updateReview(Long seq, String category, String name, String title, String content) {
        // 해당 리뷰 수정
        reviewQureyDSLRepository.updateReview(seq, category, name, title, content);
    }
	
}
