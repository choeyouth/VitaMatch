package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.VwReview;

public interface ReviewRepository extends JpaRepository<VwReview, Long>{

}
