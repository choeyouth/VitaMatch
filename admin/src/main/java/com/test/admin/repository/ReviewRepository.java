package com.test.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.admin.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
}
