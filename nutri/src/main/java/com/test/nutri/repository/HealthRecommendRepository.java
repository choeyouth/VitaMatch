package com.test.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.nutri.entity.VwHealthRecommend;

public interface HealthRecommendRepository extends JpaRepository<VwHealthRecommend, Long> {

	@Query("select h from VwHealthRecommend h where h.healthSeq = ?1")
	List<VwHealthRecommend> listAll(int healthSeq);

	@Query("select h from VwHealthRecommend h where h.healthSeq = ?1")
	List<VwHealthRecommend> findAll(String healthSeq);
	
}
