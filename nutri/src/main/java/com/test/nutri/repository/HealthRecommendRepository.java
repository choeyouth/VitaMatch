package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.vwHealthRecommend;

public interface HealthRecommendRepository extends JpaRepository<vwHealthRecommend, Long> {

	@Query("select h from vwHealthRecommend h where h.healthSeq = ?1")
	List<vwHealthRecommend> listAll(int healthSeq);
	
}
