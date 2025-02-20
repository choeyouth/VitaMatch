package com.test.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.admin.dao.ReviewQueryRepository;
import com.test.admin.dto.ReviewDTO;
import com.test.admin.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	private final ReviewQueryRepository reviewQueryDSLRepository;

	public int getCount() {
		return (int) reviewRepository.count();
	}

	public List<ReviewDTO> getReviewList(int offset, int limit) {
		return reviewQueryDSLRepository.findAllPagenation(offset, limit)
				.stream().map(review -> review.toDTO()).toList();
	}

	public ReviewDTO get(Long seq) {
		return reviewRepository.findById(seq).get().toDTO();
	}

}
